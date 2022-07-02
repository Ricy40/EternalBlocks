package com.ricy40.etb.Entities;

import com.ricy40.etb.EternalBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, EternalBlocks.MODID);

    public static final RegistryObject<EntityType<Boat>> ALDER_BOAT = registerEntity("alder_boat",
            EntityType.Builder.<Boat>of(Boat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> pBuilder) {
        return ENTITIES.register(name, () -> pBuilder.build(name));
    }

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
