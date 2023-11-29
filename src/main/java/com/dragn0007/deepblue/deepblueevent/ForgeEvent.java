package com.dragn0007.deepblue.deepblueevent;

import com.dragn0007.deepblue.util.config.DeepBlueCommonConfig;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomes(BiomeLoadingEvent event) {
        switch (event.getCategory()) {
            case OCEAN -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.HAMMERHEAD.get(), DeepBlueCommonConfig.HAMMERHEAD_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.WHALESHARK.get(), DeepBlueCommonConfig.WHALESHARK_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.SHRIMP.get(), DeepBlueCommonConfig.SHRIMPSWARM_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.KRILL.get(), DeepBlueCommonConfig.KRILLSWARM_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.BLUEWHALE.get(), DeepBlueCommonConfig.BLUEWHALE_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.MAKO.get(), DeepBlueCommonConfig.MAKO_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(DeepBlueEvent.GREATWHITE.get(), DeepBlueCommonConfig.GREATWHITE_WEIGHT.get(), 1, 1));
            }
            case SWAMP -> {
            }
            case RIVER -> {
            }
            case DESERT -> {
            }
            case MUSHROOM -> {
            }
            case NETHER -> {
            }
            case UNDERGROUND -> {
            }
            case MOUNTAIN -> {
            }
            case TAIGA -> {
            }
            case EXTREME_HILLS -> {
            }
            case JUNGLE -> {
            }
            case MESA -> {
            }
            case PLAINS -> {
            }
            case SAVANNA -> {
            }
            case ICY -> {
            }
            case THEEND -> {
            }
            case BEACH -> {
            }
            case FOREST -> {
            }
        }
    }
}
