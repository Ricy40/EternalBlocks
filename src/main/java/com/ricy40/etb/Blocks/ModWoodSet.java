package com.ricy40.etb.Blocks;

import com.ricy40.etb.Items.ModCreativeModeTab;
import com.ricy40.etb.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModWoodSet {

    public final WoodType WOODTYPE;
    public final RegistryObject<LeavesBlock> LEAVES;
    public final RegistryObject<SaplingBlock> SAPLING;
    public final RegistryObject<RotatedPillarBlock> LOG;
    public final RegistryObject<RotatedPillarBlock> WOOD;
    public final RegistryObject<RotatedPillarBlock> STRIPPED_LOG;
    public final RegistryObject<RotatedPillarBlock> STRIPPED_WOOD;
    public final RegistryObject<Block> PLANKS;
    public final RegistryObject<SlabBlock> SLAB;
    public final RegistryObject<StairBlock> STAIRS;
    public final RegistryObject<DoorBlock> DOOR;
    public final RegistryObject<TrapDoorBlock> TRAPDOOR;
    public final RegistryObject<FenceBlock> FENCE;
    public final RegistryObject<FenceGateBlock> FENCE_GATE;
    public final RegistryObject<PressurePlateBlock> PRESSURE_PLATE;
    public final RegistryObject<ButtonBlock> BUTTON;
    public final RegistryObject<SignBlock> SIGN;
    public final RegistryObject<WallSignBlock> WALL_SIGN;
    public final RegistryObject<VerticalSlabBlock> VERTICAL_SLAB;
    public final RegistryObject<ChestBlock> CHEST;
    public final RegistryObject<TrappedChestBlock> TRAPPED_CHEST;
    public final RegistryObject<LadderBlock> LADDER;
    public final RegistryObject<LeafCarpetBlock> LEAF_CARPET;
    public final RegistryObject<HedgeBlock> HEDGE;
    public final RegistryObject<Block> VERTICAL_PLANKS;
    public final RegistryObject<PostBlock> POST;
    public final RegistryObject<PostBlock> STRIPPED_POST;

    public <T extends AbstractTreeGrower> ModWoodSet(DeferredRegister<Block> register, String name, T treeGrower, MaterialColor woodColour, MaterialColor barkColour, Block strippedPost) {
        this.WOODTYPE = WoodType.create(name);
        this.LEAVES = registerBlockWithItem(register, name + "_leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModWoodSet::ocelotOrParrot).isSuffocating(ModWoodSet::never).isViewBlocking(ModWoodSet::never)));
        this.SAPLING = registerBlockWithItem(register, name + "_sapling", () -> new SaplingBlock(treeGrower, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
        this.LOG = registerBlockWithItem(register, name + "_log", () -> log(woodColour, barkColour));
        this.WOOD = registerBlockWithItem(register, name + "_wood", () -> strippedLog(barkColour));
        this.STRIPPED_LOG = registerBlockWithItem(register, "stripped_" + name + "_log", () -> log(woodColour, woodColour));
        this.STRIPPED_WOOD = registerBlockWithItem(register, "stripped_" + name + "_wood", () -> strippedLog(woodColour));
        this.PLANKS = registerBlockWithItem(register, name + "_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, woodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.VERTICAL_PLANKS = registerBlockWithItem(register, name + "_vertical_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, woodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.SLAB = registerBlockWithItem(register, name + "_slab", () ->  new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.STAIRS = registerBlockWithItem(register, name + "_stairs", () ->  new StairBlock(() -> this.PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(this.PLANKS.get())));
        this.DOOR = registerBlockWithItem(register, name + "_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, this.PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
        this.TRAPDOOR = registerBlockWithItem(register, name + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(ModWoodSet::never)));
        this.FENCE = registerBlockWithItem(register, name + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, this.PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.FENCE_GATE = registerBlockWithItem(register, name + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, this.PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.PRESSURE_PLATE = registerBlockWithItem(register, name + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, this.PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)));
        this.BUTTON = registerBlockWithItem(register, name + "_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
        this.SIGN = registerBlockWithItem(register, name + "_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), this.WOODTYPE));
        this.WALL_SIGN = registerBlockWithoutItem(register, name + "wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(this.SIGN.get()), WoodType.OAK));
        this.VERTICAL_SLAB = registerBlockWithItem(register, name + "_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.CHEST = registerBlockWithItem(register, name + "_chest", () -> new ChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), () -> {return BlockEntityType.CHEST;}));
        this.TRAPPED_CHEST = registerBlockWithItem(register, name + "_trapped_chest", () -> new TrappedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
        this.LADDER = registerBlockWithItem(register, name + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.4F).sound(SoundType.LADDER).noOcclusion()));
        this.LEAF_CARPET = registerBlockWithItem(register, name + "_leaf_carpet", () -> new LeafCarpetBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.0F).randomTicks().sound(SoundType.GRASS)));
        this.HEDGE = registerBlockWithItem(register, name + "_hedge", () -> new HedgeBlock(BlockBehaviour.Properties.of(Material.WOOD, woodColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.POST = registerBlockWithItem(register, name + "_post", () -> new PostBlock(strippedPost, BlockBehaviour.Properties.of(Material.WOOD, barkColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
        this.STRIPPED_POST = registerBlockWithItem(register, name + "_stripped_post", () -> new PostBlock(this.POST.get(), BlockBehaviour.Properties.of(Material.WOOD, barkColour).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithItem(DeferredRegister<Block> register, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = register.register(name, block);
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
