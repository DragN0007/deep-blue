package com.dragn0007.deepblue.world;

import com.dragn.bettas.BettasMain;
import com.dragn0007.deepblue.world.gen.FishSpawnGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber (modid = BettasMain.MODID)
public class DeepBlueWorldEvents {



    @SubscribeEvent
            public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

    FishSpawnGeneration.onEntitySpawn(event);
    }
}
