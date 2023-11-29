package com.dragn0007.deepblue.entities.hammerhead;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum HammerheadVariant {
    HARLEY(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/hammerhead_harley.png")),
    HAMMOND(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/hammerhead_hammond.png")),
    HEATHER(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/hammerhead_heather.png"));

    public final ResourceLocation resourceLocation;

    HammerheadVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static HammerheadVariant patternFromOrdinal(int pattern) {
        return HammerheadVariant.values()[pattern % HammerheadVariant.values().length];
    }
}
