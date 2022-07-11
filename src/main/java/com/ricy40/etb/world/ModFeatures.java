package com.ricy40.etb.world;

import com.google.common.collect.ImmutableList;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.EternalBlocks;
import com.ricy40.etb.world.foliageplacers.AlderFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, EternalBlocks.MODID);

    public static class TreeConfigs {

        public static BlockStateProvider NO_SAPLING = new ModSimpleStateProvider(Blocks.OAK_SAPLING.defaultBlockState());

        public static final TreeConfiguration.TreeConfigurationBuilder ALDER_TREE = new TreeConfiguration.TreeConfigurationBuilder(
                new ModSimpleStateProvider(ModBlocks.ALDER.LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(6, 2, 2),
                new ModSimpleStateProvider(ModBlocks.ALDER.LEAVES.get().defaultBlockState()),
                new AlderFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 1),
                new TwoLayersFeatureSize(1, 0, 1));
        public static final TreeConfiguration.TreeConfigurationBuilder ALDER_FANCY_TREE = new TreeConfiguration.TreeConfigurationBuilder(
                new ModSimpleStateProvider(ModBlocks.ALDER.LOG.get().defaultBlockState()),
                new FancyTrunkPlacer(10, 1, 2),
                    new ModSimpleStateProvider(ModBlocks.ALDER.LEAVES.get().defaultBlockState()),
                new AlderFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 1),
                new TwoLayersFeatureSize(1, 0, 1));

        static SimpleWeightedRandomList.Builder<BlockState> weightedBlockStateBuilder() {
            return SimpleWeightedRandomList.builder();
        }
    }
}
