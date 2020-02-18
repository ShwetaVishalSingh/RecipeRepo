package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;

import java.util.List;

public interface RecipeRepository {
    List<DatabaseRecipe> fetchAllRecipes();

    DatabaseRecipe fetchRecipeById(String recipeId);

    DatabaseRecipe deleteRecipeById(String recipeId);

    void addRecipes(Paylaod paylaod);

    DatabaseRecipe updateRecipe(String recipeId, Paylaod paylaod);
}
