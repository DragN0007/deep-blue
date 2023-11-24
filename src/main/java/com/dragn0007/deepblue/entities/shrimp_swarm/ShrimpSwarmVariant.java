package com.dragn0007.deepblue.entities.shrimp_swarm;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum ShrimpSwarmVariant {
    DEFAULT (new ResourceLocation(DeepBlueMain.MODID, "textures/other/shrimp.png"));

    public final ResourceLocation resourceLocation;

    ShrimpSwarmVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static ShrimpSwarmVariant patternFromOrdinal(int pattern) {
        return ShrimpSwarmVariant.values()[pattern % ShrimpSwarmVariant.values().length];
    }
}
