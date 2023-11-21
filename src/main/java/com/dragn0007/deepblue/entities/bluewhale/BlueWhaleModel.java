package com.dragn0007.deepblue.entities.bluewhale;

import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteVariant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BlueWhaleModel extends AnimatedGeoModel<BlueWhale> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(DeepBlueMain.MODID, "geo/bluewhale.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(DeepBlueMain.MODID, "animations/whale1.animation.json");

    @Override
    public ResourceLocation getModelLocation(BlueWhale greatWhite) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(BlueWhale BlueWhale) {
        return BlueWhaleVariant.patternFromOrdinal(BlueWhale.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BlueWhale greatWhite) {
        return animationResource;
    }
}
