package com.ricy40.etb.Blocks;

import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.world.level.block.LeavesBlock;

public class ModLeavesBlock extends LeavesBlock {
    public ModLeavesBlock(Properties properties) {
        super(properties);
        ModItemBlockRenderTypes.addCutoutMipped(this);
    }
}
