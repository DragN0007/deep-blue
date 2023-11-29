package com.dragn0007.deepblue.entities.hammerhead;

import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteVariant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HammerheadModel extends AnimatedGeoModel<Hammerhead> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(DeepBlueMain.MODID, "geo/hammerhead.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(DeepBlueMain.MODID, "animations/shark1.animation.json");

    @Override
    public ResourceLocation getModelLocation(Hammerhead greatWhite) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(Hammerhead greatWhite) {
        return HammerheadVariant.patternFromOrdinal(greatWhite.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Hammerhead greatWhite) {
        return animationResource;
    }
}
