package com.ricy40.etb.util;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModItemBlockRenderTypes {

    public static final List<Block> CUTOUT_MIPPED = new ArrayList<Block>();
    public static final List<Block> CUTOUT = new ArrayList<Block>();

    public static void addCutoutMipped(Block block) {
        CUTOUT_MIPPED.add(block);
    }
    public static void addCutout(Block block) {
        CUTOUT.add(block);
    }

    public static void registerRenderTypes() {
        for (Block block: CUTOUT_MIPPED) {
            ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutoutMipped());
        }
        for (Block block: CUTOUT) {
            ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
        }
    }
}
