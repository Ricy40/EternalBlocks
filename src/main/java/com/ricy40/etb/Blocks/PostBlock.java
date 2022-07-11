package com.ricy40.etb.Blocks;

import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import java.util.Iterator;

public class PostBlock extends Block implements SimpleWaterloggedBlock {
    private static final VoxelShape SHAPE_X = box(0.0, 6.0, 6.0, 16.0, 10.0, 10.0);
    private static final VoxelShape SHAPE_Y = box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape SHAPE_Z = box(6.0, 6.0, 0.0, 10.0, 10.0, 16.0);
    private static final BooleanProperty WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS;
    public static final BooleanProperty[] CHAINED;
    private final Block block;

    public PostBlock(Block block, Properties properties) {
        super(properties);
        this.block = block;
        BlockState defaultState = (BlockState)((BlockState)((BlockState)this.getStateDefinition().any()).getBlock().defaultBlockState().setValue(WATERLOGGED, false)).setValue(AXIS, Direction.Axis.Y);
        BooleanProperty[] var3 = CHAINED;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            BooleanProperty property = var3[var5];
            defaultState = (BlockState)defaultState.setValue(property, false);
        }

        this.registerDefaultState(defaultState);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape var10000;
        switch ((Direction.Axis)state.getValue(AXIS)) {
            case X:
                var10000 = SHAPE_X;
                break;
            case Y:
                var10000 = SHAPE_Y;
                break;
            default:
                var10000 = SHAPE_Z;
        }

        return var10000;
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return !(Boolean)state.getValue(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.getRelevantState(context.getLevel(), context.getClickedPos(), context.getClickedFace().getAxis());
    }

    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        BlockState newState = this.getRelevantState(worldIn, pos, (Direction.Axis)state.getValue(AXIS));
        if (!newState.equals(state)) {
            worldIn.setBlockAndUpdate(pos, newState);
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED, AXIS});
        BooleanProperty[] var2 = CHAINED;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            BooleanProperty property = var2[var4];
            builder.add(new Property[]{property});
        }

    }

    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolAction.get("axe")) {
            return this.block != null ? transferAllBlockStates(state, this.block.defaultBlockState()) : null;
        } else {
            return super.getToolModifiedState(state, context, toolAction, simulate);
        }
    }

    private BlockState getRelevantState(Level world, BlockPos pos, Direction.Axis axis) {
        BlockState state = (BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, world.getFluidState(pos).getType() == Fluids.WATER)).setValue(AXIS, axis);
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            if (direction.getAxis() != axis) {
                BlockState sideState = world.getBlockState(pos.relative(direction));
                if (sideState.getBlock() instanceof ChainBlock && sideState.getValue(BlockStateProperties.AXIS) == direction.getAxis() || direction == Direction.DOWN && sideState.getBlock() instanceof LanternBlock && (Boolean)sideState.getValue(LanternBlock.HANGING)) {
                    BooleanProperty property = CHAINED[direction.ordinal()];
                    state = (BlockState)state.setValue(property, true);
                }
            }
        }

        return state;
    }

    public static BlockState transferAllBlockStates(BlockState initial, BlockState after) {
        BlockState block = after;
        Iterator var3 = initial.getBlock().getStateDefinition().getProperties().iterator();

        while(var3.hasNext()) {
            Property property = (Property)var3.next();
            if (after.hasProperty(property)) {
                initial.getValue(property);
                block = (BlockState)block.setValue(property, initial.getValue(property));
            }
        }

        return block;
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        AXIS = BlockStateProperties.AXIS;
        CHAINED = new BooleanProperty[]{BooleanProperty.create("chain_down"), BooleanProperty.create("chain_up"), BooleanProperty.create("chain_north"), BooleanProperty.create("chain_south"), BooleanProperty.create("chain_west"), BooleanProperty.create("chain_east")};
    }
}
