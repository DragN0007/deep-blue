package com.dragn0007.deepblue.entities.coelacanth;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;


public enum CoelVariant {
    A(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_1.png")),
    B(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_2.png")),
    C(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_3.png")),
    D(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_4.png")),
    E(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_5.png")),
    F(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_6.png")),
    G(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_7.png")),
    H(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_8.png")),
    I(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_9.png")),
    J(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_10.png")),
    K(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_11.png")),
    L(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_12.png")),
    M(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_13.png")),
    N(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_14.png")),
    O(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_15.png")),
    P(new ResourceLocation(DeepBlueMain.MODID, "textures/other/coelacanth_16.png"));

    public final ResourceLocation resourceLocation;

    CoelVariant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static CoelVariant patternFromOrdinal(int pattern) {
        return CoelVariant.values()[pattern % CoelVariant.values().length];
    }
}
