package com.dragn0007.deepblue.entities.whaleshark;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum WhaleSharkVariant {
    STARS(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/whaleshark_stars.png")),
    GALAXY(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/whaleshark_galaxy.png"));

    public final ResourceLocation resourceLocation;

    WhaleSharkVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static WhaleSharkVariant patternFromOrdinal(int pattern) {
        return WhaleSharkVariant.values()[pattern % WhaleSharkVariant.values().length];
    }
}
