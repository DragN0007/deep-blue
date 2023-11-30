package com.dragn0007.deepblue.deepblueevent;


import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.deepblueblocks.DeepBlueBlocks;
import com.dragn0007.deepblue.entities.AbstractMarineMammal;
import com.dragn0007.deepblue.entities.AbstractShark;
import com.dragn0007.deepblue.entities.bluewhale.BlueWhale;
import com.dragn0007.deepblue.entities.bluewhale.BlueWhaleRender;
import com.dragn0007.deepblue.entities.coelacanth.Coel;
import com.dragn0007.deepblue.entities.coelacanth.CoelRender;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteRender;
import com.dragn0007.deepblue.entities.hammerhead.Hammerhead;
import com.dragn0007.deepblue.entities.hammerhead.HammerheadRender;
import com.dragn0007.deepblue.entities.krill_swarm.KrillSwarm;
import com.dragn0007.deepblue.entities.krill_swarm.KrillSwarmRender;
import com.dragn0007.deepblue.entities.krill_swarm.KrillSwarmVariant;
import com.dragn0007.deepblue.entities.mako.Mako;
import com.dragn0007.deepblue.entities.mako.MakoRender;
import com.dragn0007.deepblue.entities.shrimp_swarm.ShrimpSwarm;
import com.dragn0007.deepblue.entities.shrimp_swarm.ShrimpSwarmRender;
import com.dragn0007.deepblue.entities.whaleshark.WhaleShark;
import com.dragn0007.deepblue.entities.whaleshark.WhaleSharkRender;
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
    public static final RegistryObject<EntityType<WhaleShark>> WHALESHARK = ENTITY_TYPES.register
            ("whaleshark", () -> EntityType.Builder.of
                    (WhaleShark::new, MobCategory.WATER_AMBIENT).sized(4f, 4f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "whaleshark").toString()));
    public static final RegistryObject<EntityType<Hammerhead>> HAMMERHEAD = ENTITY_TYPES.register
            ("hammerhead", () -> EntityType.Builder.of
                    (Hammerhead::new, MobCategory.WATER_AMBIENT).sized(1.5f, 1.5f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "hammerhead").toString()));
    public static final RegistryObject<EntityType<Coel>> COEL = ENTITY_TYPES.register
            ("coel", () -> EntityType.Builder.of
                    (Coel::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.7f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "coel").toString()));
    public static final RegistryObject<EntityType<KrillSwarm>> KRILL = ENTITY_TYPES.register
            ("krill", () -> EntityType.Builder.of
                    (KrillSwarm::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "krill").toString()));
    public static final RegistryObject<EntityType<ShrimpSwarm>> SHRIMP = ENTITY_TYPES.register
            ("shrimp", () -> EntityType.Builder.of
                    (ShrimpSwarm::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "shrimp").toString()));

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(GREATWHITE.get(), GreatWhite.createAttributes().build());
        event.put(MAKO.get(), GreatWhite.createAttributes().build());
        event.put(BLUEWHALE.get(), BlueWhale.createAttributes().build());
        event.put(WHALESHARK.get(), WhaleShark.createAttributes().build());
        event.put(HAMMERHEAD.get(), Hammerhead.createAttributes().build());
        event.put(COEL.get(), Coel.createAttributes().build());
        event.put(KRILL.get(), KrillSwarm.createAttributes().build());
        event.put(SHRIMP.get(), ShrimpSwarm.createAttributes().build());
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

        EntityRenderers.register(WHALESHARK.get(), WhaleSharkRender::new);
        SpawnPlacements.register(WHALESHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractMarineMammal::checkWhaleSpawnRules);

        EntityRenderers.register(HAMMERHEAD.get(), HammerheadRender::new);
        SpawnPlacements.register(HAMMERHEAD.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractShark::checkSharkSpawnRules);

        EntityRenderers.register(COEL.get(), CoelRender::new);
        SpawnPlacements.register(COEL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Coel::checkGenericFreshwaterSpawnRules);

        EntityRenderers.register(KRILL.get(), KrillSwarmRender::new);
        SpawnPlacements.register(KRILL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                KrillSwarm::checkSwarmSpawnRules);

        EntityRenderers.register(SHRIMP.get(), ShrimpSwarmRender::new);
        SpawnPlacements.register(SHRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ShrimpSwarm::checkSwarmSpawnRules);



        /* BLOCK REGISTER RENDERERS */
        ItemBlockRenderTypes.setRenderLayer(DeepBlueBlocks.AQUA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DeepBlueBlocks.AQUA_GLASS_SLAB.get(), RenderType.translucent());



    }





}
