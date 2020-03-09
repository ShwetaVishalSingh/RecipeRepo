package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> fetchAllRecipes() throws Exception;

    Recipe fetchRecipeById(String recipeId) throws Exception;

    void deleteRecipeById(String recipeId);

    void addRecipes(Paylaod paylaod);

    default void updateRecipe(String recipeId, Paylaod paylaod) throws Exception {

    }
}
