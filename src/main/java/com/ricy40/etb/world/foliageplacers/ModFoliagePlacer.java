package com.ricy40.etb.world.foliageplacers;

import com.ricy40.etb.Blocks.ModFlowerLikeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Material;

import java.util.Iterator;
import java.util.Random;
import java.util.function.BiConsumer;

public class ModFoliagePlacer extends FoliagePlacer {
    protected void createSquare3x3(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -1), pos.offset(1, yOffset, 1)).iterator();

        while(var8.hasNext()) {
            BlockPos blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createSquareRandom3x3(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -1), pos.offset(1, yOffset, 1)).iterator();

        while(var8.hasNext()) {
            BlockPos blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createCross3x3(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        placeLeaf(world, leaves, random, config, pos.offset(-1, yOffset, 0));
        placeLeaf(world, leaves, random, config, pos.offset(1, yOffset, 0));
        placeLeaf(world, leaves, random, config, pos.offset(0, yOffset, -1));
        placeLeaf(world, leaves, random, config, pos.offset(0, yOffset, 1));
    }

    protected void createCrossRandom3x3(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        this.placeRandomLeaf(world, pos.offset(-1, yOffset, 0), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(1, yOffset, 0), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(0, yOffset, -1), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(0, yOffset, 1), random, config, leaves);
    }

    protected void createSquare5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -2), pos.offset(2, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -2), pos.offset(2, yOffset, 2)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createSquareRandom5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -2), pos.offset(2, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -2), pos.offset(2, yOffset, 2)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createCross5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -1), pos.offset(2, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -2), pos.offset(1, yOffset, 2)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createCrossRandom5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -1), pos.offset(2, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -2), pos.offset(1, yOffset, 2)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createDiagonalSquare5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -1), pos.offset(1, yOffset, 1)).iterator();

        while(var8.hasNext()) {
            BlockPos blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        placeLeaf(world, leaves, random, config, pos.offset(-2, yOffset, 0));
        placeLeaf(world, leaves, random, config, pos.offset(2, yOffset, 0));
        placeLeaf(world, leaves, random, config, pos.offset(0, yOffset, -2));
        placeLeaf(world, leaves, random, config, pos.offset(0, yOffset, 2));
    }

    protected void createDiagonalSquareRandom5x5(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -1), pos.offset(1, yOffset, 1)).iterator();

        while(var8.hasNext()) {
            BlockPos blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        this.placeRandomLeaf(world, pos.offset(-2, yOffset, 0), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(2, yOffset, 0), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(0, yOffset, -2), random, config, leaves);
        this.placeRandomLeaf(world, pos.offset(0, yOffset, 2), random, config, leaves);
    }

    protected void createCross7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -1), pos.offset(3, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -3), pos.offset(1, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createCrossRandom7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -1), pos.offset(3, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -3), pos.offset(1, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createSquare7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -3), pos.offset(3, yOffset, 3)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -3), pos.offset(3, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createSquareRandom7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -3), pos.offset(3, yOffset, 3)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -3), pos.offset(3, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createRoundedSquare7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -2), pos.offset(3, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -3), pos.offset(2, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createRoundedSquareRandom7x7(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-3, yOffset, -2), pos.offset(3, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -3), pos.offset(2, yOffset, 3)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createCross9x9(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-4, yOffset, -1), pos.offset(4, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -4), pos.offset(1, yOffset, 4)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createCrossRandom9x9(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-4, yOffset, -1), pos.offset(4, yOffset, 1)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-1, yOffset, -4), pos.offset(1, yOffset, 4)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void createRoundedSquare9x9(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-4, yOffset, -2), pos.offset(4, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -4), pos.offset(2, yOffset, 4)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            placeLeaf(world, leaves, random, config, blockPos);
        }

    }

    protected void createRoundedSquareRandom9x9(LevelSimulatedReader world, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves, FoliagePlacer.FoliageAttachment foliage, int yOffset) {
        BlockPos pos = foliage.pos().immutable();
        Iterator var8 = BlockPos.betweenClosed(pos.offset(-4, yOffset, -2), pos.offset(4, yOffset, 2)).iterator();

        BlockPos blockPos;
        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

        var8 = BlockPos.betweenClosed(pos.offset(-2, yOffset, -4), pos.offset(2, yOffset, 4)).iterator();

        while(var8.hasNext()) {
            blockPos = (BlockPos)var8.next();
            this.placeRandomLeaf(world, blockPos, random, config, leaves);
        }

    }

    protected void placeNSLogAt(LevelSimulatedReader world, BlockPos pos, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> log) {
        if (TreeFeature.isAirOrLeaves(world, pos)) {
            log.accept(pos, (BlockState)config.trunkProvider.getState(random, pos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
        }

    }

    protected void placeEWLogAt(LevelSimulatedReader world, BlockPos pos, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> log) {
        if (TreeFeature.isAirOrLeaves(world, pos)) {
            log.accept(pos, (BlockState)config.trunkProvider.getState(random, pos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
        }

    }

    protected void placeRandomLeaf(LevelSimulatedReader world, BlockPos pos, RandomSource random, TreeConfiguration config, BiConsumer<BlockPos, BlockState> leaves) {
        if (random.nextBoolean()) {
            placeLeaf(world, leaves, random, config, pos);
        }

    }

    protected static void placeLeaf(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> leaves, RandomSource random, TreeConfiguration config, BlockPos pos) {
        if (TreeFeature.validTreePos(world, pos)) {
            leaves.accept(pos, (BlockState)config.foliageProvider.getState(random, pos).setValue(LeavesBlock.DISTANCE, 1));
        }

    }

    protected void placeLeafRowForceReplaceFlowers(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> posSet, RandomSource random, TreeConfiguration config, BlockPos pos, int p_161443_, int p_161444_, boolean bool) {
        int i = bool ? 1 : 0;
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for(int j = -p_161443_; j <= p_161443_ + i; ++j) {
            for(int k = -p_161443_; k <= p_161443_ + i; ++k) {
                if (!this.shouldSkipLocationSigned(random, j, p_161444_, k, p_161443_, bool)) {
                    mutable.setWithOffset(pos, j, p_161444_, k);
                    placeLeafNoFlowers(world, posSet, random, config, mutable);
                }
            }
        }

    }

    protected static void placeLeafNoFlowers(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> leaves, RandomSource random, TreeConfiguration config, BlockPos pos) {
        if (validTreePosWithForceReplaceFlower(world, pos)) {
            leaves.accept(pos, config.foliageProvider.getState(random, pos));
        }

    }

    public static boolean validTreePosWithForceReplaceFlower(LevelSimulatedReader world, BlockPos pos) {
        return TreeFeature.isAirOrLeaves(world, pos) || isReplaceablePlant(world, pos) || isBlockWater(world, pos) || isFlower(world, pos) || isGEFlower(world, pos);
    }

    private static boolean isReplaceablePlant(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (plantInstance) -> {
            Material material = plantInstance.getMaterial();
            return material == Material.REPLACEABLE_PLANT;
        });
    }

    private static boolean isBlockWater(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (fluidInstance) -> {
            return fluidInstance.is(Blocks.WATER);
        });
    }

    private static boolean isFlower(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (flowerInstance) -> {
            return flowerInstance.is(BlockTags.SMALL_FLOWERS);
        });
    }

    private static boolean isGEFlower(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos, (flowerInstance) -> {
            return flowerInstance.getBlock() instanceof ModFlowerLikeBlock;
        });
    }

    public ModFoliagePlacer(IntProvider featureSpread1, IntProvider featureSpread2) {
        super(featureSpread1, featureSpread2);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return null;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader p_225613_, BiConsumer<BlockPos, BlockState> p_225614_, RandomSource p_225615_, TreeConfiguration p_225616_, int p_225617_, FoliageAttachment p_225618_, int p_225619_, int p_225620_, int p_225621_) {

    }

    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource p_225595_, int p_225596_, int p_225597_, int p_225598_, int p_225599_, boolean p_225600_) {
        return false;
    }
}
