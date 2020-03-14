package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domain.RecipeRepository;
import com.recipe.se.recipes.domain.StoreNotFoundException;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;

import java.util.List;

public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> fetchAllRecipies() throws Exception {
       return recipeRepository.fetchAllRecipes();
    }

    public Recipe fetchRecipeById(String recipeId) throws Exception {
       return recipeRepository.fetchRecipeById(recipeId);
    }

    public void deleteRecipeById(String recipeId) {

        recipeRepository.deleteRecipeById(recipeId);
    }

    public void addRecipes(Paylaod paylaod) throws StoreNotFoundException {
        recipeRepository.addRecipes(paylaod);
    }

    public void updateRecipe(String recipeId, Paylaod paylaod) throws Exception {
        recipeRepository.updateRecipe(recipeId, paylaod);
    }

    public List < Recipe> fetchByStore(String storeId) {
         return recipeRepository.fetchByStore(storeId);
    }
}
