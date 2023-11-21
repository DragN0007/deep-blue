package com.dragn0007.deepblue.entities.bluewhale;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BlueWhaleRender extends GeoEntityRenderer<BlueWhale> {
    public BlueWhaleRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlueWhaleModel());
    }
}
