package com.ricy40.etb.world.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ricy40.etb.world.ModTreePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.Random;
import java.util.function.BiConsumer;

public class AlderFoliagePlacer extends ModFoliagePlacer {
    public static final Codec<AlderFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return foliagePlacerParts(instance).and(Codec.intRange(0, 16).fieldOf("height").forGetter((renderType) -> {
            return renderType.height;
        })).apply(instance, AlderFoliagePlacer::new);
    });
    private final int height;

    public AlderFoliagePlacer(IntProvider radius, IntProvider yOffset, int bottomOffset) {
        super(radius, yOffset);
        this.height = bottomOffset;
    }

    protected FoliagePlacerType<?> type() {
        return ModTreePlacers.ALDER_FOLIAGE.get();
    }

    protected void m_142539_(LevelSimulatedReader generationReader, BiConsumer<BlockPos, BlockState> posSet, RandomSource random, TreeConfiguration config, int trunkHeight, FoliagePlacer.FoliageAttachment foliage, int foliageHeight, int radius, int offset) {
        BlockPos pos = foliage.pos().immutable();
        if (foliage.doubleTrunk()) {
            placeLeaf(generationReader, posSet, random, config, pos.above(1));
            this.createCross3x3(generationReader, random, config, posSet, foliage, 1);
            this.createCross3x3(generationReader, random, config, posSet, foliage, 0);
        } else {
            placeLeaf(generationReader, posSet, random, config, pos.offset(-1, 0, 0));
            placeLeaf(generationReader, posSet, random, config, pos.offset(1, 0, 0));
            placeLeaf(generationReader, posSet, random, config, pos.offset(0, 0, -1));
            placeLeaf(generationReader, posSet, random, config, pos.offset(0, 0, 1));
            placeLeaf(generationReader, posSet, random, config, pos.above(0));
            this.createSquare3x3(generationReader, random, config, posSet, foliage, -1);
            this.createCrossRandom5x5(generationReader, random, config, posSet, foliage, -1);
            this.createSquare3x3(generationReader, random, config, posSet, foliage, -2);
            this.createCrossRandom5x5(generationReader, random, config, posSet, foliage, -2);
            this.createSquare3x3(generationReader, random, config, posSet, foliage, -3);
            this.createCrossRandom5x5(generationReader, random, config, posSet, foliage, -3);
            this.createSquare3x3(generationReader, random, config, posSet, foliage, -4);
            this.createCrossRandom5x5(generationReader, random, config, posSet, foliage, -4);
            if (trunkHeight >= 8) {
                this.createCross5x5(generationReader, random, config, posSet, foliage, -4);
                this.createCrossRandom7x7(generationReader, random, config, posSet, foliage, -4);
                this.createDiagonalSquare5x5(generationReader, random, config, posSet, foliage, -5);
            }
        }

    }

    public int m_5969_(RandomSource random, int currentWidth, TreeConfiguration config) {
        return 0;
    }

    protected boolean m_7394_(RandomSource random, int x, int y, int z, int radius, boolean bool) {
        return x == radius && z == radius && (random.nextInt(2) == 0 || y == 0);
    }
}
