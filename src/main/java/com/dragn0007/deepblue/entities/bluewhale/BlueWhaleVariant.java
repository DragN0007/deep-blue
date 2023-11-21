package com.dragn0007.deepblue.entities.bluewhale;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum BlueWhaleVariant {
    KINGSLEY(new ResourceLocation(DeepBlueMain.MODID, "textures/whale/bluewhale_kingsley2.png"));

    public final ResourceLocation resourceLocation;

    BlueWhaleVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static BlueWhaleVariant patternFromOrdinal(int pattern) {
        return BlueWhaleVariant.values()[pattern % BlueWhaleVariant.values().length];
    }
}
