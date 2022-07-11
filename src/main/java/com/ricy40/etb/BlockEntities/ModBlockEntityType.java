package com.ricy40.etb.BlockEntities;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.Blocks.ModWoodSet;
import com.ricy40.etb.EternalBlocks;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.function.Supplier;

public class ModBlockEntityType {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EternalBlocks.MODID);

    public static final RegistryObject<BlockEntityType<SignBlockEntity>> SIGN = registerSignBlockEntity("alder_sign",
            ModBlockEntityType.Builder.of(SignBlockEntity::new,
                    ModBlocks.ALDER_SIGN.get(), ModBlocks.ALDER_WALL_SIGN.get()));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerSignBlockEntity(String name, ModBlockEntityType.Builder<T> pBuilder) {
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, name);
        return BLOCK_ENTITIES.register(name, () -> pBuilder.build(type));
    }

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

    public static final class Builder<T extends BlockEntity> {
        private final BlockEntityType.BlockEntitySupplier<? extends T> factory;
        final Set<Block> validBlocks;

        private Builder(BlockEntityType.BlockEntitySupplier<? extends T> pFactory, Set<Block> pValidBlocks) {
            this.factory = pFactory;
            this.validBlocks = pValidBlocks;
        }

        public static <T extends BlockEntity> ModBlockEntityType.Builder<T> of(BlockEntityType.BlockEntitySupplier<? extends T> pFactory, Block... pValidBlocks) {
            return new ModBlockEntityType.Builder<>(pFactory, ImmutableSet.copyOf(pValidBlocks));
        }

        public BlockEntityType<T> build(Type<?> pDataType) {
            return new BlockEntityType<>(this.factory, this.validBlocks, pDataType);
        }
    }

}
