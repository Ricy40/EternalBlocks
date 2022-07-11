package com.ricy40.etb.Blocks;

import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LeafCarpetBlock extends Block {
    private final VoxelShape SHAPE = box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

    public LeafCarpetBlock(Properties properties) {
        super(properties);
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return this.SHAPE;
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        if (state.is(this) && worldIn.getBlockState(pos.below()).isAir()) {
            return false;
        } else {
            return !worldIn.isEmptyBlock(pos.below());
        }
    }
}
