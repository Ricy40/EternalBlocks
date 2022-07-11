package com.ricy40.etb.Blocks;

import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Objects;

public class HedgeBlock extends FenceBlock {
    public static final TagKey<Block> HEDGES = BlockTags.create(new ResourceLocation("quark", "hedges"));
    public static final BooleanProperty EXTEND = BooleanProperty.create("extend");

    public HedgeBlock(Properties properties) {
        super(properties);
        ModItemBlockRenderTypes.addCutoutMipped(this);
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        return state.is(HEDGES);
    }

    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return facing == Direction.UP && !(Boolean)state.getValue(WATERLOGGED) && plantable.getPlantType(world, pos) == PlantType.PLAINS;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)((BlockState) Objects.requireNonNull(super.getStateForPlacement(context))).setValue(EXTEND, context.getLevel().getBlockState(context.getClickedPos().below()).is(HEDGES));
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Blocks.WATER, Fluids.WATER.getTickDelay(world));
        }

        return facing == Direction.DOWN ? (BlockState)state.setValue(EXTEND, facingState.is(HEDGES)) : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{EXTEND});
    }
}
