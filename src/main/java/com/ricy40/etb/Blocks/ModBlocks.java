package com.ricy40.etb.Blocks;

import com.ricy40.etb.EternalBlocks;
import com.ricy40.etb.Items.ModCreativeModeTab;
import com.ricy40.etb.Items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EternalBlocks.MODID);

    public static final ModWoodSet ALDER = new ModWoodSet(BLOCKS, "alder", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.alder_stripped_post);
    public static final ModWoodSet APPLE = new ModWoodSet(BLOCKS, "apple", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.apple_stripped_post);
    public static final ModWoodSet ASH = new ModWoodSet(BLOCKS, "ash", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.ash_stripped_post);
    public static final ModWoodSet ASPEN = new ModWoodSet(BLOCKS, "aspen", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.aspen_stripped_post);

    private <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModCreativeModeTab.ETERNAL_BLOCKS);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }


}
