package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> fetchAllRecipes();

    DatabaseRecipe fetchRecipeById(String recipeId);

    void deleteRecipeById(String recipeId);

    void addRecipes(Paylaod paylaod);

    DatabaseRecipe updateRecipe(String recipeId, Paylaod paylaod);
}
