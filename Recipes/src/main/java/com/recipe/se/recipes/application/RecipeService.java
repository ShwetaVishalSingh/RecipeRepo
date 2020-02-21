package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domian.RecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

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

    public void addRecipes(Paylaod paylaod) {
        recipeRepository.addRecipes(paylaod);
    }

    public void updateRecipe(String recipeId, Paylaod paylaod) throws Exception {
        recipeRepository.updateRecipe(recipeId, paylaod);
    }
}
