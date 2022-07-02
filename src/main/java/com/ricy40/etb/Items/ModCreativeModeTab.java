package com.ricy40.etb.Items;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ETERNAL_BLOCKS = new CreativeModeTab("eternalblocks") {

        @Override
        public ItemStack makeIcon() {
            return null;// new ItemStack(ModItems..get());
        }
    };
}
