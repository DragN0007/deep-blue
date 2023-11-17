package com.dragn0007.deepblue.deepblueitems;


import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.deepblueevent.DeepBlueEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dragn.bettas.BettasMain.BETTAS_TAB;


public class DeepBlueItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeepBlueMain.MODID);

    public static final RegistryObject<ForgeSpawnEggItem> GREATWHITE_SPAWN_EGG = ITEMS.register("greatwhite_spawn_egg", () -> new ForgeSpawnEggItem(DeepBlueEvent.GREATWHITE, 0xb0b0b0, 0xd6d6d6, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GREATWHITE_NET = ITEMS.register("greatwhite_net", () -> new MobBucketItem(DeepBlueEvent.GREATWHITE, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> MAKO_SPAWN_EGG = ITEMS.register("mako_spawn_egg", () -> new ForgeSpawnEggItem(DeepBlueEvent.MAKO, 0x5f83a5, 0xd6d6d6, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> MAKO_NET = ITEMS.register("mako_net", () -> new MobBucketItem(DeepBlueEvent.MAKO, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}