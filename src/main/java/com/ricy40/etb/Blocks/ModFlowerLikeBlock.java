package com.ricy40.etb.Blocks;

import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModFlowerLikeBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 10.0, 11.0);

    public ModFlowerLikeBlock(Properties properties) {
        super(properties); //GEProperties.GENERIC_FLOWER);
        ModItemBlockRenderTypes.addCutout(this);
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Vec3 vector3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public boolean canSurvive(BlockState blockState, LevelReader worldReader, BlockPos pos) {
        BlockState groundState = worldReader.getBlockState(pos.below());
        Block block = groundState.getBlock();
        if (this != StaticBlockReferences.golden_suncup && this != StaticBlockReferences.gilia) {
            return super.canSurvive(blockState, worldReader, pos);
        } else {
            return block == Blocks.SAND || block == Blocks.RED_SAND || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.GRASS_BLOCK;
        }
    }
}
