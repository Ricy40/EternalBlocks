package com.ricy40.etb.Blocks;

import com.ricy40.etb.EternalBlocks;
import com.ricy40.etb.Items.ModCreativeModeTab;
import com.ricy40.etb.Items.ModItems;
import com.ricy40.etb.world.TreeGrowers.AlderTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EternalBlocks.MODID);
    
    //Alder

    private static final MaterialColor alderWoodColour = MaterialColor.WOOD;
    private static final MaterialColor alderBarkColour = MaterialColor.PODZOL;
    public static final WoodType ALDER_WOODTYPE = WoodType.create("alder");
    public static final RegistryObject<LeavesBlock> ALDER_LEAVES = registerBlockWithItem("alder" + "_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));
    public static final RegistryObject<SaplingBlock> ALDER_SAPLING = registerBlockWithItem("alder" + "_sapling", () -> new SaplingBlock(new AlderTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<RotatedPillarBlock> ALDER_LOG = registerBlockWithItem("alder" + "_log", () -> log(alderWoodColour, alderBarkColour));
    public static final RegistryObject<RotatedPillarBlock> ALDER_WOOD = registerBlockWithItem("alder" + "_wood", () -> strippedLog(alderBarkColour));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_LOG = registerBlockWithItem("stripped_" + "alder" + "_log", () -> log(alderWoodColour, alderWoodColour));
    public static final RegistryObject<RotatedPillarBlock> ALDER_STRIPPED_WOOD = registerBlockWithItem("stripped_" + "alder" + "_wood", () -> strippedLog(alderWoodColour));
    public static final RegistryObject<Block> ALDER_PLANKS = registerBlockWithItem("alder" + "_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, alderWoodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ALDER_VERTICAL_PLANKS = registerBlockWithItem("alder" + "_vertical_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, alderWoodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<SlabBlock> ALDER_SLAB = registerBlockWithItem("alder" + "_slab", () ->  new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, alderWoodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<StairBlock> ALDER_STAIRS = registerBlockWithItem("alder" + "_stairs", () ->  new StairBlock(() -> ALDER_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ALDER_PLANKS.get())));
    public static final RegistryObject<DoorBlock> ALDER_DOOR = registerBlockWithItem("alder" + "_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, ALDER_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> ALDER_TRAPDOOR = registerBlockWithItem("alder" + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(ModBlocks::never)));
    public static final RegistryObject<FenceBlock> ALDER_FENCE = registerBlockWithItem("alder" + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, ALDER_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> ALDER_FENCE_GATE = registerBlockWithItem("alder" + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, ALDER_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<PressurePlateBlock> ALDER_PRESSURE_PLATE = registerBlockWithItem("alder" + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, ALDER_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<WoodButtonBlock> ALDER_BUTTON = registerBlockWithItem("alder" + "_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<StandingSignBlock> ALDER_SIGN = registerBlockWithItem("alder" + "_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), ALDER_WOODTYPE));
    public static final RegistryObject<WallSignBlock> ALDER_WALL_SIGN = registerBlockWithoutItem("alder" + "wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ALDER_SIGN.get()), WoodType.OAK));
    public static final RegistryObject<VerticalSlabBlock> ALDER_VERTICAL_SLAB = registerBlockWithItem("alder" + "_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, alderWoodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<ChestBlock> ALDER_CHEST = registerBlockWithItem("alder" + "_chest", () -> new ChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return BlockEntityType.CHEST;}));
    public static final RegistryObject<TrappedChestBlock> ALDER_TRAPPED_CHEST = registerBlockWithItem("alder" + "_trapped_chest", () -> new TrappedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<LadderBlock> ALDER_LADDER = registerBlockWithItem("alder" + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.4F).sound(SoundType.LADDER).noOcclusion()));
    public static final RegistryObject<LeafCarpetBlock> ALDER_LEAF_CARPET = registerBlockWithItem("alder" + "_leaf_carpet", () -> new LeafCarpetBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.0F).randomTicks().sound(SoundType.GRASS)));
    public static final RegistryObject<HedgeBlock> ALDER_HEDGE = registerBlockWithItem("alder" + "_hedge", () -> new HedgeBlock(BlockBehaviour.Properties.of(Material.WOOD, alderWoodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<PostBlock> ALDER_POST = registerBlockWithItem("alder" + "_post", () -> new PostBlock(StaticBlockReferences.alder_stripped_post, BlockBehaviour.Properties.of(Material.WOOD, alderBarkColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<PostBlock> ALDER_STRIPPED_POST = registerBlockWithItem("alder" + "_stripped_post", () -> new PostBlock(ALDER_POST.get(), BlockBehaviour.Properties.of(Material.WOOD, alderBarkColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));



    //public static final ModWoodSet ALDER = new ModWoodSet(BLOCKS, "alder", new AlderTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.alder_stripped_post);
    /*
    public static final ModWoodSet APPLE = new ModWoodSet(BLOCKS, "apple", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.apple_stripped_post);
    public static final ModWoodSet ASH = new ModWoodSet(BLOCKS, "ash", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.ash_stripped_post);
    public static final ModWoodSet ASPEN = new ModWoodSet(BLOCKS, "aspen", new OakTreeGrower(), MaterialColor.WOOD, MaterialColor.PODZOL, StaticBlockReferences.aspen_stripped_post);
    */
    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModCreativeModeTab.ETERNAL_BLOCKS);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(DeferredRegister<Block> register, String name, Supplier<T> block) {
        return register.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }


    private static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static RotatedPillarBlock log(MaterialColor pWoodColor, MaterialColor pBarkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (wood) -> {
            return wood.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pWoodColor : pBarkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    private static RotatedPillarBlock strippedLog(MaterialColor pWoodColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pWoodColor).strength(2.0F).sound(SoundType.WOOD));
    }
}