package com.ricy40.etb.world.TreeGrowers;

import com.ricy40.etb.world.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class AlderTreeGrower extends AbstractTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        if (random.nextInt(10) == 0) {
            return bees ? ModConfiguredFeatures.ALDER_FANCY_TREE_BEES.getHolder().get() : ModConfiguredFeatures.ALDER_FANCY_TREE.getHolder().get();
        } else {
            return bees ? ModConfiguredFeatures.ALDER_TREE_BEES.getHolder().get() : ModConfiguredFeatures.ALDER_TREE.getHolder().get();
        }
    }
}
