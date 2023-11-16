package com.dragn0007.deepblue;

import com.dragn0007.deepblue.deepblueblocks.DeepBlueBlocks;
import com.dragn0007.deepblue.deepblueevent.DeepBlueEvent;
import com.dragn0007.deepblue.deepblueitems.DeepBlueItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(DeepBlueMain.MODID)
public class DeepBlueMain
{
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "deepblue";

    public DeepBlueMain()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        DeepBlueItems.register(eventBus);
        DeepBlueBlocks.register(eventBus);
        DeepBlueEvent.ENTITY_TYPES.register(eventBus);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("Hello, sharks! >> {}", DeepBlueEvent.GREATWHITE.get().getRegistryName());
    }
}
