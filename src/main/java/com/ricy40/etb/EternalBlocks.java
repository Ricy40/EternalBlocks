package com.ricy40.etb;

import com.ricy40.etb.BlockEntities.ModBlockEntityType;
import com.ricy40.etb.Blocks.ModBlocks;
import com.ricy40.etb.Items.ModItems;
import com.ricy40.etb.util.ModItemBlockRenderTypes;
import com.ricy40.etb.world.ModConfiguredFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        ModConfiguredFeatures.register(bus);
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
