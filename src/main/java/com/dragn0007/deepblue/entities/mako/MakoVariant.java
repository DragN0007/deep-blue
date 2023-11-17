package com.dragn0007.deepblue.entities.mako;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum MakoVariant {
    MANNY(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/mako_manny.png")),
    MARTHA(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/mako_martha.png")),
    BLIZZARD(new ResourceLocation(DeepBlueMain.MODID, "textures/shark/mako_blizzard.png"));

    public final ResourceLocation resourceLocation;

    MakoVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static MakoVariant patternFromOrdinal(int pattern) {
        return MakoVariant.values()[pattern % MakoVariant.values().length];
    }
}
