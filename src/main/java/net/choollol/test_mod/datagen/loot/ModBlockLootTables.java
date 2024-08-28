package net.choollol.test_mod.datagen.loot;

import net.choollol.test_mod.blocks.ModBlocks;
import net.choollol.test_mod.vessels.BlockVessel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TEST_BLOCK_1.asBlock());
        dropSelf(ModBlocks.TEST_BLOCK_2.asBlock());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().<Block>map(DeferredHolder::get).toList();
    }
}
