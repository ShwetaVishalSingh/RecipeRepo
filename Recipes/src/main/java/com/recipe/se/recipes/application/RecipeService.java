package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domian.RecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;

import java.util.List;

public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> fetchAllRecipies() {
       return recipeRepository.fetchAllRecipes();
    }

    public DatabaseRecipe fetchRecipeById(String recipeId) {
       return recipeRepository.fetchRecipeById(recipeId);
    }

    public void deleteRecipeById(String recipeId) {
        recipeRepository.deleteRecipeById(recipeId);
    }

    public void addRecipes(Paylaod paylaod) {
        recipeRepository.addRecipes(paylaod);
    }

    public DatabaseRecipe updateRecipe(String recipeId, Paylaod paylaod) {
        return recipeRepository.updateRecipe(recipeId, paylaod);
    }
}
