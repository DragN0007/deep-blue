package com.dragn0007.deepblue.deepblueevent;


import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.deepblueblocks.DeepBlueBlocks;
import com.dragn0007.deepblue.entities.AbstractMarineMammal;
import com.dragn0007.deepblue.entities.AbstractShark;
import com.dragn0007.deepblue.entities.bluewhale.BlueWhale;
import com.dragn0007.deepblue.entities.bluewhale.BlueWhaleRender;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteRender;
import com.dragn0007.deepblue.entities.mako.Mako;
import com.dragn0007.deepblue.entities.mako.MakoRender;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DeepBlueMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeepBlueEvent {


    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, DeepBlueMain.MODID);

    public static final RegistryObject<EntityType<GreatWhite>> GREATWHITE = ENTITY_TYPES.register
            ("greatwhite", () -> EntityType.Builder.of
                    (GreatWhite::new, MobCategory.WATER_AMBIENT).sized(2f, 2f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "greatwhite").toString()));
    public static final RegistryObject<EntityType<Mako>> MAKO = ENTITY_TYPES.register
            ("mako", () -> EntityType.Builder.of
                    (Mako::new, MobCategory.WATER_AMBIENT).sized(1f, 1f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "mako").toString()));
    public static final RegistryObject<EntityType<BlueWhale>> BLUEWHALE = ENTITY_TYPES.register
            ("bluewhale", () -> EntityType.Builder.of
                    (BlueWhale::new, MobCategory.WATER_AMBIENT).sized(5f, 5f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "bluewhale").toString()));

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(GREATWHITE.get(), GreatWhite.createAttributes().build());
        event.put(MAKO.get(), GreatWhite.createAttributes().build());
        event.put(BLUEWHALE.get(), BlueWhale.createAttributes().build());
    }
    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* ENTITY REGISTER RENDERERS & SPAWN PLACEMENTS */
        EntityRenderers.register(GREATWHITE.get(), GreatWhiteRender::new);
        SpawnPlacements.register(GREATWHITE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractShark::checkSharkSpawnRules);

        EntityRenderers.register(MAKO.get(), MakoRender::new);
        SpawnPlacements.register(MAKO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractShark::checkSharkSpawnRules);

        EntityRenderers.register(BLUEWHALE.get(), BlueWhaleRender::new);
        SpawnPlacements.register(BLUEWHALE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractMarineMammal::checkWhaleSpawnRules);



        /* BLOCK REGISTER RENDERERS */
        ItemBlockRenderTypes.setRenderLayer(DeepBlueBlocks.AQUA_GLASS.get(), RenderType.translucent());



    }





}
