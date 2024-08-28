package net.choollol.test_mod.util;

import net.choollol.test_mod.blocks.ModBlocks;
import net.choollol.test_mod.items.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

public class RecipeHelper {
    public static void fullBlock(RecipeOutput recipeOutput, RecipeCategory recipeCategory,
                                                Block block, TagKey<Item> ingredient,
                                                String unlockedByName, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(recipeCategory, block)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ingredient)
                .unlockedBy(unlockedByName, criterion)
                .save(recipeOutput);

    }
    public static void fullBlock(RecipeOutput recipeOutput, RecipeCategory recipeCategory,
                                 Block block, Item ingredient,
                                 String unlockedByName, Criterion<?> criterion){
        ShapedRecipeBuilder.shaped(recipeCategory, block)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ingredient)
                .unlockedBy(unlockedByName, criterion)
                .save(recipeOutput);

    }
}
