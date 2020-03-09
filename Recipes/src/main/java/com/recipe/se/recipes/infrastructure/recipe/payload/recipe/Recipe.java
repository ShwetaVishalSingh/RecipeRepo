package com.recipe.se.recipes.infrastructure.recipe.payload.recipe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;

import java.util.HashSet;
import java.util.Set;

public class Recipe {
    private String recipeId;
    private String recipeName;
    private String portion;
    private Set<Ingredient> ingredients;
    private Set<String> storeIds;

    @JsonCreator
    public Recipe(@JsonProperty("recipeId") String recipeId, @JsonProperty("recipeName")  String recipeName,
                  @JsonProperty("portion") String portion, @JsonProperty("ingredients") Set<Ingredient> ingredients,
                  @JsonProperty("storeIds") Set<String> storeIds) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
        this.storeIds = storeIds;
    }

    public static Recipe convertToRecipe(DatabaseRecipe databaseRecipe) {
        return new Recipe(databaseRecipe.getRecipeId(),databaseRecipe.getRecipeName(),databaseRecipe.getPortion(), convertIngredientsToUserIngredients(databaseRecipe.getIngredients()),
                convertToStores(databaseRecipe.getDatabaseStores()));
    }

    private static Set<String> convertToStores(Set<DatabaseStore> databaseStores) {
        Set<String> stores = new HashSet<>();
        for (DatabaseStore store: databaseStores) {
            stores.add(store.getStoreId());
        }
        return stores;
    }
/*

    convertToStores(databaseRecipe.getDatabaseStores())
    private static Set<String> convertToStores(Set<DatabaseStore> databaseStores) {
        Set<String> stores = new HashSet<>();
        for (DatabaseStore store: databaseStores ) {
            stores.add(store.getStoreId());
        }
        return stores;
    }
*/

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

    public Set<String> getStoreIds() {
        return storeIds;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId='" + recipeId + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", portion='" + portion + '\'' +
                ", ingredients=" + ingredients +
                ", storeIds=" + storeIds +
                '}';
    }
}
