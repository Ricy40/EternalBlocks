package com.ricy40.etb.world;

import com.mojang.serialization.Codec;
import com.ricy40.etb.EternalBlocks;
import com.ricy40.etb.world.foliageplacers.AlderFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModTreePlacers {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, EternalBlocks.MODID);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, EternalBlocks.MODID);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, EternalBlocks.MODID);
    public static final RegistryObject<FoliagePlacerType<AlderFoliagePlacer>> ALDER_FOLIAGE = registerFoliagePlacer("alder_foliage", () -> new FoliagePlacerType<>(AlderFoliagePlacer.CODEC));

    private static <P extends TrunkPlacer> RegistryObject<TrunkPlacerType<P>> registerTrunkPlacer(String name, Supplier<TrunkPlacerType<P>> trunkPlacerType) {
        return TRUNK_PLACERS.register(name, trunkPlacerType);
    }

    public static <T extends TreeDecorator> RegistryObject<TreeDecoratorType<T>> registerTreeDecorator(String name, Supplier<TreeDecoratorType<T>> treePlacerType) {
        return TREE_DECORATORS.register(name, treePlacerType);
    }

    public static <F extends FoliagePlacer> RegistryObject<FoliagePlacerType<F>> registerFoliagePlacer(String name, Supplier<FoliagePlacerType<F>> foliagePlacerType) {
        return FOLIAGE_PLACERS.register(name, foliagePlacerType);
    }
}
