package com.ricy40.etb.world;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class ModSimpleStateProvider extends BlockStateProvider {
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

    public BlockState getState(RandomSource p_225907_, BlockPos p_225908_) {
        return null;
    }
}
