package com.dragn0007.deepblue.deepblueitems;


import com.dragn0007.deepblue.DeepBlueMain;
import com.dragn0007.deepblue.deepblueevent.DeepBlueEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.FurnaceFuelSlot;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MobBucketItem;
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

    public static final RegistryObject<ForgeSpawnEggItem> BLUEWHALE_SPAWN_EGG = ITEMS.register("bluewhale_spawn_egg", () -> new ForgeSpawnEggItem(DeepBlueEvent.BLUEWHALE, 0x314457, 0xc9c9c0, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> BLUEWHALE_NET = ITEMS.register("bluewhale_net", () -> new MobBucketItem(DeepBlueEvent.BLUEWHALE, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));



    //Loot
    public static final RegistryObject<Item> SHARK_MEAT = ITEMS.register("shark_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build()).tab(BETTAS_TAB)));
    public static final RegistryObject<Item> COOKED_SHARK_MEAT = ITEMS.register("cooked_shark_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationMod(1).meat().build()).tab(BETTAS_TAB)));

    public static final RegistryObject<Item> WHALE_MEAT = ITEMS.register("whale_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0).meat().build()).tab(BETTAS_TAB)));
    public static final RegistryObject<Item> COOKED_WHALE_MEAT = ITEMS.register("cooked_whale_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(12).saturationMod(1).meat().build()).tab(BETTAS_TAB)));

    public static final RegistryObject<Item> WHALE_BALEEN = ITEMS.register("whale_baleen",
            () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> BLUBBER = ITEMS.register("blubber",
            () -> new BlubberItem(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> SHARK_LEATHER = ITEMS.register("shark_leather",
            () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> SHARK_FIN = ITEMS.register("shark_fin",
            () -> new Item(new Item.Properties().tab(BETTAS_TAB)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}