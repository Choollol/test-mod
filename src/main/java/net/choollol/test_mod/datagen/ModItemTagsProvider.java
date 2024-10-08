package net.choollol.test_mod.datagen;

import net.choollol.test_mod.registration.ModBlocks;
import net.choollol.test_mod.registration.ModItems;
import net.choollol.test_mod.TM;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, TM.ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for (var itemVessel : ModItems.ITEM_MAP.values()){
            for (var tag : itemVessel.getTags()){
                this.tag(tag).add(itemVessel.asItem());
            }
        }
        for (var blockVessel : ModBlocks.BLOCK_MAP.values()){
            for (TagKey<Item> tag : blockVessel.getBlockItemVessel().getTags()){
                this.tag(tag).add(blockVessel.asItem());
            }
        }
    }
}
