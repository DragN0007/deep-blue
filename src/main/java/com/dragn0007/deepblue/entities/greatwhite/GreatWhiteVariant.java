package com.dragn0007.deepblue.entities.greatwhite;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum GreatWhiteVariant {
    REINER(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/greatwhite_reiner.png")),
    GERALT(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/greatwhite_geralt.png")),
    BIGBETTY(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/greatwhite_bigbetty.png"));

    public final ResourceLocation resourceLocation;

    GreatWhiteVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static GreatWhiteVariant patternFromOrdinal(int pattern) {
        return GreatWhiteVariant.values()[pattern % GreatWhiteVariant.values().length];
    }
}
