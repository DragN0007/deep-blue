package com.dragn0007.deepblue.entities.whaleshark;


import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WhaleSharkRender extends GeoEntityRenderer<WhaleShark> {
    public WhaleSharkRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WhaleSharkModel());
    }
}
