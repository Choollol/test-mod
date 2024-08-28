package net.choollol.test_mod.datagen.recipes;

import net.choollol.test_mod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class MaterialRecipeProvider extends ModRecipeProvider {
    public MaterialRecipeProvider(PackOutput packOutput, ModRecipeProvider... recipeProviders) {
        super(packOutput, recipeProviders);
    }
    @Override
    protected void buildRecipes(RecipeOutput recipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEST_ITEM_1.get().get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" D ")
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(recipeOutput);
    }
}
