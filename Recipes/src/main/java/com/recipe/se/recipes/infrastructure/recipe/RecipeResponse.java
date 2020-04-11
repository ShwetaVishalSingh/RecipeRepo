package com.recipe.se.recipes.infrastructure.recipe;

import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;

import java.util.List;

public class RecipeResponse {
    List<Recipe> recipeList;
    private String message;

    public RecipeResponse(List<Recipe> recipeList, String message) {
        this.recipeList = recipeList;
        this.message = message;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
