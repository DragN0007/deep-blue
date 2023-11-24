package com.dragn0007.deepblue.entities.krill_swarm;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum KrillSwarmVariant {
    DEFAULT (new ResourceLocation(DeepBlueMain.MODID, "textures/other/krill.png"));

    public final ResourceLocation resourceLocation;

    KrillSwarmVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static KrillSwarmVariant patternFromOrdinal(int pattern) {
        return KrillSwarmVariant.values()[pattern % KrillSwarmVariant.values().length];
    }
}
