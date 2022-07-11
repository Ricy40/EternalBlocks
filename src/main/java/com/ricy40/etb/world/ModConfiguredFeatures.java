package com.ricy40.etb.world;

import com.mojang.serialization.Codec;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.Blocks.ModWoodSet;
import com.ricy40.etb.EternalBlocks;
import com.ricy40.etb.world.foliageplacers.AlderFoliagePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, EternalBlocks.MODID);
    public static List<String> configuredFeatureList = new ArrayList<>();

    private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
    private static final BeehiveDecorator BEEHIVE_001 = new BeehiveDecorator(0.01F);
    private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
    private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);
    private static final BeehiveDecorator BEEHIVE = new BeehiveDecorator(1.0F);

    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ALDER_TREE = registerConfiguredFeature("alder_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, ModFeatures.TreeConfigs.ALDER_TREE.build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ALDER_TREE_BEES = registerConfiguredFeature("alder_tree_bees",
            () -> new ConfiguredFeature<>(Feature.TREE, ModFeatures.TreeConfigs.ALDER_TREE.decorators(List.of(BEEHIVE_005)).build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ALDER_FANCY_TREE = registerConfiguredFeature("alder_fancy_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, ModFeatures.TreeConfigs.ALDER_FANCY_TREE.build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ALDER_FANCY_TREE_BEES = registerConfiguredFeature("alder_fancy_tree_bees",
            () -> new ConfiguredFeature<>(Feature.TREE, ModFeatures.TreeConfigs.ALDER_FANCY_TREE.decorators(List.of(BEEHIVE_005)).build()));

    /*
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> APPLE_TREE = registerConfiguredFeature("apple_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakFootPrint(ModBlocks.APPLE).build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ASH_TREE = registerConfiguredFeature("ash_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakFootPrint(ModBlocks.ASH).build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> ASPEN_TREE = registerConfiguredFeature("aspen_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, );
    */


    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }

    public static <T extends FeatureConfiguration> RegistryObject<ConfiguredFeature<T, ?>> registerConfiguredFeature(String name, Supplier<ConfiguredFeature<T, ?>> feature) {
        configuredFeatureList.add(name);
        return CONFIGURED_FEATURES.register(name, feature);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves, int pBaseHeight, int pHeightRandA, int pHeightRandB, int blob) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB), BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(blob), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createOakFootPrint(ModWoodSet set) {
        return createStraightBlobTree(set.LOG.get(), set.LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }
}