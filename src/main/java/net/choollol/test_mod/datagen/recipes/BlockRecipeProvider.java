package net.choollol.test_mod.datagen.recipes;

import net.choollol.test_mod.registries.ModBlocks;
import net.choollol.test_mod.registries.ModItems;
import net.choollol.test_mod.util.RecipeHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.neoforged.neoforge.common.Tags;

public class BlockRecipeProvider extends ModRecipeProvider {
    public BlockRecipeProvider(PackOutput packOutput, ModRecipeProvider... recipeProviders) {
        super(packOutput, recipeProviders);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        RecipeHelper.fullBlock(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TEST_BLOCK_2.asBlock(),
                Tags.Items.COBBLESTONE, getHasName(ModItems.TEST_ITEM_1.asItem()), has(ModItems.TEST_ITEM_1.asItem()));
    }
}
