package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> fetchAllRecipes() throws Exception;

    Recipe fetchRecipeById(String recipeId) throws Exception;

    void deleteRecipeById(String recipeId);

    void addRecipes(Paylaod paylaod);

    void updateRecipe(String recipeId, Paylaod paylaod) throws Exception;
}
