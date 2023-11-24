package com.dragn0007.deepblue.util;

import com.dragn0007.deepblue.DeepBlueMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DeepBlueTags {

    public static class Items {
        public static final TagKey<Item> LEATHER = forgeTag("leather");
        public static final TagKey<Item> STRING = forgeTag("string");
        public static final TagKey<Item> RAW_SHARK_MEAT = forgeTag("raw_shark_meat");
        public static final TagKey<Item> COOKED_SHARK_MEAT = forgeTag("cooked_shark_meat");
        public static final TagKey<Item> RAW_WHALE_MEAT = forgeTag("raw_whale_meat");
        public static final TagKey<Item> COOKED_WHALE_MEAT = forgeTag("cooked_whale_meat");
        public static final TagKey<Item> COOKED_SHRIMP = forgeTag("cooked_shrimp");


        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(DeepBlueMain.MODID, name));
        }
        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
