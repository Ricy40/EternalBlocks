package com.ricy40.etb;

import com.ricy40.etb.BlockEntities.ModBlockEntityType;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.Items.ModItems;
import com.ricy40.etb.util.ModItemBlockRenderTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("etb")
public class EternalBlocks {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "etb";

    public EternalBlocks() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::enqueueIMC);

        ModItems.register(bus);
        ModBlocks.register(bus);

        ModBlockEntityType.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            Sheets.addWoodType(ModBlocks.ALDER.WOODTYPE);

        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        ModItemBlockRenderTypes.registerRenderTypes();
    }
}
