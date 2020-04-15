package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.infrastructure.recipe.RecipeDetails;
import com.recipe.se.recipes.infrastructure.recipe.RecipeModel;

import java.util.List;

public interface RecipeRepository {
    List<RecipeModel> fetchAllRecipes() throws Exception;

    RecipeModel fetchRecipeById(String recipeId) throws Exception;

    void deleteRecipeById(String recipeId);

    void addRecipes(RecipeDetails recipeDetails) throws StoreNotFoundException;

     void updateRecipe(String recipeId, RecipeDetails paylaod) throws RecipeNotFoundException;

    List<RecipeModel> fetchByStore(String storeId);

    List<RecipeModel> findRecipeBy(String searchTerm);
}
