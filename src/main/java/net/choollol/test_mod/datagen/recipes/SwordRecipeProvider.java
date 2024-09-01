package net.choollol.test_mod.datagen.recipes;

import net.choollol.test_mod.registration.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class SwordRecipeProvider extends ModRecipeProvider {
    public SwordRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }
    @Override
    protected void buildRecipes(RecipeOutput recipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TEST_ITEM_2.get().get())
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" T ")
                .define('T', ModItems.TEST_ITEM_1.get().get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.TEST_ITEM_1.get()), has(ModItems.TEST_ITEM_1.get()))
                .save(recipeOutput);
    }
}
