package net.choollol.test_mod.datagen;

import net.choollol.test_mod.registries.ModBlocks;
import net.choollol.test_mod.TM;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TM.ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for (var blockVessel : ModBlocks.BLOCK_MAP.values()){
            for (var tag : blockVessel.getTags()){
                this.tag(tag).add(blockVessel.get().get());
            }
        }
    }
}
