package com.recipe.se.recipes.infrastructure.recipe.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;

import java.util.HashSet;
import java.util.Set;

public class Recipe {
    private String recipeId;
    private String recipeName;
    private String portion;
    private Set<Ingredient> ingredients;

    @JsonCreator
    public Recipe(@JsonProperty("recipeId") String recipeId, @JsonProperty("recipeName")  String recipeName,
                  @JsonProperty("portion") String portion, @JsonProperty("ingredients") Set<Ingredient> ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
    }

    public static Recipe convertToRecipe(DatabaseRecipe databaseRecipe) {
        return new Recipe(databaseRecipe.getRecipeId(),databaseRecipe.getRecipeName(),databaseRecipe.getPortion(), convertIngredientsToUserIngredients(databaseRecipe.getIngredients()));
    }

    private static Set<Ingredient> convertIngredientsToUserIngredients(Set<com.recipe.se.recipes.infrastructure.recipe.h2.Ingredient> ingredients) {
        Set<Ingredient> ingredientSet = new HashSet<>();
        for (com.recipe.se.recipes.infrastructure.recipe.h2.Ingredient ingredient: ingredients ) {
            ingredientSet.add(new Ingredient(ingredient.getId(),ingredient.getName(),ingredient.getAmount(),ingredient.getUnit()));
        }
        return ingredientSet;
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

    public Set<Ingredient> getIngredients() {
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
