package com.dragn0007.deepblue.entities.greatwhite;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GreatWhiteRender extends GeoEntityRenderer<GreatWhite> {
    public GreatWhiteRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GreatWhiteModel());
    }
}
