package net.choollol.test_mod.datagen.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput, ModRecipeProvider... recipeProviders) {
        super(packOutput);
        this.recipeProviders.addAll(Arrays.asList(recipeProviders));
    }

    List<ModRecipeProvider> recipeProviders = new ArrayList<>();

    /*
    SHAPED RECIPE TEMPLATE

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEST_ITEM_2.get().get())
                .pattern("")
                .pattern("")
                .pattern("")
                .define('T', ModItems.TEST_ITEM_1.get().get())
                .unlockedBy(getHasName(ModItems.TEST_ITEM_1.get()), has(ModItems.TEST_ITEM_1.get()))
                .save(recipeOutput);


    ADDING NEW RECIPEPROVIDER CLASS

    1. Create class, extend this class
    2. Add buildRecipes() method
    3. Add to DataGenerators
     */

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        recipeProviders.forEach(r -> r.buildRecipes(pRecipeOutput));
    }
}
