package com.dragn0007.deepblue.world.gen;

import com.dragn0007.deepblue.deepblueevent.DeepBlueEvent;
import com.dragn0007.deepblue.util.config.DeepBlueCommonConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class FishSpawnGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToSpecificBiomes(event, DeepBlueEvent.BLUEWHALE.get(),
                DeepBlueCommonConfig.BLUEWHALE_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.GREATWHITE.get(),
                DeepBlueCommonConfig.GREATWHITE_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.MAKO.get(),
                DeepBlueCommonConfig.MAKO_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.KRILL.get(),
                DeepBlueCommonConfig.KRILLSWARM_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.SHRIMP.get(),
                DeepBlueCommonConfig.SHRIMPSWARM_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.COEL.get(),
                DeepBlueCommonConfig.COELACANTH_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, DeepBlueEvent.WHALESHARK.get(),
                DeepBlueCommonConfig.WHALESHARK_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);
    }


    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }
}
