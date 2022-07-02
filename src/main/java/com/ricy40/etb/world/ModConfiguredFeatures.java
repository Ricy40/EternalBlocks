package com.ricy40.etb.world;

import com.mojang.serialization.Codec;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.EternalBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
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

    public static final RegistryObject<ConfiguredFeature<?, ?>> ALDER_TREE = registerConfiguredFeature("alder_tree", Feature.TREE.configured(
            new TreeConfiguration.TreeConfigurationBuilder(new ModSimpleStateProvider(ModBlocks.ALDER.LOG.get().defaultBlockState()), new StraightTrunkPlacer(6, 2, 2), new ModSimpleStateProvider(ModBlocks.ALDER.LEAVES.get().defaultBlockState()), new ModSimpleStateProvider(ModBlocks.ALDER.SAPLING.get().defaultBlockState()), new AlderFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), 1), new TwoLayersFeatureSize(1, 0, 1))).m_68251_()).decorated(GEFeatureUtil.zeroWaterDepth()););

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }

    public static RegistryObject<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name, Supplier<ConfiguredFeature<?, ?>> feature) {
        configuredFeatureList.add(name);
        return CONFIGURED_FEATURES.register(name, feature);
    }
}

class ModSimpleStateProvider extends BlockStateProvider {
    public static final Codec<ModSimpleStateProvider> CODEC = BlockState.CODEC.fieldOf("state").xmap(ModSimpleStateProvider::new, (p_68804_) -> {
        return p_68804_.state;
    }).codec();
    private final BlockState state;

    protected ModSimpleStateProvider(BlockState p_68801_) {
        this.state = p_68801_;
    }

    protected BlockStateProviderType<?> type() {
        return BlockStateProviderType.SIMPLE_STATE_PROVIDER;
    }

    public BlockState getState(Random pRandom, BlockPos pBlockPos) {
        return this.state;
    }
}
