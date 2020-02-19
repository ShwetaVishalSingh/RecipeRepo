package com.recipe.se.recipes.infrastructure.recipe.incoming;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    private String recipeId;
    private String recipeName;
    private String portion;
    private List<String> ingredients;

    @JsonCreator
    public Recipe(@JsonProperty("recipeId") String recipeId, @JsonProperty("recipeName")  String recipeName,
                  @JsonProperty("portion") String portion, @JsonProperty("ingredients") List<String> ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
    }

    public static Recipe of(DatabaseRecipe databaseRecipe) {
        return new Recipe(databaseRecipe.getRecipeId(),databaseRecipe.getRecipeName(),databaseRecipe.getPortion(), convertIngredientsToListOfIngredients(databaseRecipe.getIngredients()));
    }

    private static List<String> convertIngredientsToListOfIngredients(String ingredients) {
        String[] spilited = ingredients.split("-");
        return Arrays.asList(spilited);
    }

    public String getRecipeId() {
        return recipeId;
    }



    public String getRecipeName() {
        return recipeName;
    }



    public String getPortion() {
        return portion;
    }

    public List<String> getIngredients() {
        return ingredients;
    }


    @Override
    public String toString() {
        return "RecipeRequestBody{" +
                "recipeId='" + recipeId + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", portion='" + portion + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
