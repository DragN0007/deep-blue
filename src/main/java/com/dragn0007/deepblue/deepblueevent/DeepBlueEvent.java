package com.dragn0007.deepblue.deepblueevent;


import com.dragn.bettas.BettasMain;
import com.dragn.bettas.decor.Decor;
import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhite;
import com.dragn0007.deepblue.entities.greatwhite.GreatWhiteRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DeepBlueMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeepBlueEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(GREATWHITE.get(), GreatWhite.createAttributes().build());

    }
    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* REGISTER RENDERERS */
        EntityRenderers.register(GREATWHITE.get(), GreatWhiteRender::new);


        /* REGISTER SPAWN PLACEMENTS */
        SpawnPlacements.register(GREATWHITE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                GreatWhite::checkSharkSpawnRules);

    }
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, DeepBlueMain.MODID);

    public static final RegistryObject<EntityType<GreatWhite>> GREATWHITE = ENTITY_TYPES.register
            ("greatwhite", () -> EntityType.Builder.of
                    (GreatWhite::new, MobCategory.WATER_AMBIENT).sized(2f, 2f).build(new ResourceLocation(DeepBlueMain.MODID,
                    "greatwhite").toString()));




    @SubscribeEvent
    public static void registerDecor(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        BettasMain.BLOCKS.getEntries().forEach(registryObject -> {
            if (registryObject != null) {
                if (registryObject.get() instanceof Decor.Vanilla decor) {
                    decor.init();
                } else if (registryObject.get() instanceof Decor decor) {
                    String name = decor.getRegistryName().getPath();

                    Item item = (new Item(new Item.Properties().tab(BettasMain.TANK_TAB))).setRegistryName(name);
                    registry.register(item);
                    Decor.addMappings(decor, item);
                }
            }
        });
    }
}
