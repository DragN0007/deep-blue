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

        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(DeepBlueMain.MODID, name));
        }
        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
