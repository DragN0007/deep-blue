package com.dragn0007.deepblue.entities.krill_swarm;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KrillSwarmModel extends AnimatedGeoModel<KrillSwarm> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(DeepBlueMain.MODID, "geo/krill.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(DeepBlueMain.MODID, "animations/krill.animation.json");

    @Override
    public ResourceLocation getModelLocation(KrillSwarm KrillSwarm) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(KrillSwarm KrillSwarm) {
        return KrillSwarmVariant.patternFromOrdinal(KrillSwarm.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(KrillSwarm KrillSwarm) {
        return animationResource;
    }
}
