package com.recipe.se.recipes.infrastructure.recipe;

import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.RecipeModel;

import java.util.List;

public class RecipeResponse {
    List<RecipeModel> recipeList;
    private String message;


    public RecipeResponse(List<RecipeModel> recipeList, String message) {
        this.recipeList = recipeList;
        this.message = message;
    }

    public List<RecipeModel> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<RecipeModel> recipeList) {
        this.recipeList = recipeList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
