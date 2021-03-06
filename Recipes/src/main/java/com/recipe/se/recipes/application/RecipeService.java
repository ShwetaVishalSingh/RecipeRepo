package com.recipe.se.recipes.application;


import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.domain.repository.RecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.RecipeDetails;
import com.recipe.se.recipes.infrastructure.recipe.RecipeModel;

import java.util.List;

public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeModel> fetchAllRecipes() throws Exception {
       return recipeRepository.fetchAllRecipes();
    }

    public RecipeModel fetchRecipeById(String recipeId) throws Exception {
       return recipeRepository.fetchRecipeById(recipeId);
    }

    public void deleteRecipeById(String recipeId) {

        recipeRepository.deleteRecipeById(recipeId);
    }

    public void addRecipes(RecipeDetails recipeDetails) throws StoreNotFoundException {
        recipeRepository.addRecipes(recipeDetails);
    }

    public void updateRecipe(String recipeId, RecipeDetails recipeDetails) throws Exception {
        recipeRepository.updateRecipe(recipeId, recipeDetails);
    }

    public List <RecipeModel> fetchBySeller(String sellerId) {
         return recipeRepository.fetchBySeller(sellerId);
    }

    public List<RecipeModel> findRecipeBy(String searchTerm) {
       return recipeRepository.findRecipeBy(searchTerm);

    }
}
