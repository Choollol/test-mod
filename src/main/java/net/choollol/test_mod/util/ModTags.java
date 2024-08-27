package net.choollol.test_mod.util;

import net.choollol.test_mod.TM;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> TEST_BLOCK = tag("test_block");

        private static TagKey<Block> tag(String tagName){
            return BlockTags.create(new ResourceLocation(TM.ID, tagName));
        }
    }
    public static class Items {
        public static final TagKey<Item> TEST_ITEM = tag("test_item");

        private static TagKey<Item> tag(String tagName){
            return ItemTags.create(new ResourceLocation(TM.ID, tagName));
        }
    }
}
