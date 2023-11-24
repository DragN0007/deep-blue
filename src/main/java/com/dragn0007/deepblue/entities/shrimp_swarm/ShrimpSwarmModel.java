package com.dragn0007.deepblue.entities.shrimp_swarm;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShrimpSwarmModel extends AnimatedGeoModel<ShrimpSwarm> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(DeepBlueMain.MODID, "geo/krill.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(DeepBlueMain.MODID, "animations/krill.animation.json");

    @Override
    public ResourceLocation getModelLocation(ShrimpSwarm ShrimpSwarm) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(ShrimpSwarm ShrimpSwarm) {
        return ShrimpSwarmVariant.patternFromOrdinal(ShrimpSwarm.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ShrimpSwarm ShrimpSwarm) {
        return animationResource;
    }
}
