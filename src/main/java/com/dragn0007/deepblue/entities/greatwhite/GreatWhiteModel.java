package com.dragn0007.deepblue.entities.greatwhite;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreatWhiteModel extends AnimatedGeoModel<GreatWhite> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(DeepBlueMain.MODID, "geo/greatwhite.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(DeepBlueMain.MODID, "animations/shark1.animation.json");

    @Override
    public ResourceLocation getModelLocation(GreatWhite greatWhite) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GreatWhite greatWhite) {
        return GreatWhiteVariant.patternFromOrdinal(greatWhite.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GreatWhite greatWhite) {
        return animationResource;
    }
}
