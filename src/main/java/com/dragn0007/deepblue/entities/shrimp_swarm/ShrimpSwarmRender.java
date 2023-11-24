package com.dragn0007.deepblue.entities.shrimp_swarm;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ShrimpSwarmRender extends GeoEntityRenderer<ShrimpSwarm> {
    public ShrimpSwarmRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShrimpSwarmModel());
    }
}
