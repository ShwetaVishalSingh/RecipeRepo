package com.recipe.se.recipes.domain.recipe;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Payload;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> fetchAllRecipes() throws Exception;

    Recipe fetchRecipeById(String recipeId) throws Exception;

    void deleteRecipeById(String recipeId);

    void addRecipes(Payload paylaod) throws StoreNotFoundException;

     void updateRecipe(String recipeId, Payload paylaod) throws RecipeNotFoundException;



    List<Recipe> fetchByStore(String storeId);

    List<Recipe> findRecipeBy(String searchTerm);
}
