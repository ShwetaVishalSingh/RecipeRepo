package com.recipe.se.recipes.infrastructure.recipe.payload.recipe;

import com.recipe.se.recipes.infrastructure.recipe.h2.Recipe;

public class RecipeModel {
    private String id;
    private String recipeName;
    private int portion;
    private String ingredients;
    private String cookingStep;
    private String image;
    private String description;

    public RecipeModel(String id, String recipeName, int portion, String ingredients, String cookingStep, String image, String description) {
        this.id = id;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
        this.cookingStep = cookingStep;
        this.image = image;
        this.description = description;
    }

    public static RecipeModel convertToRecipe(Recipe recipe) {
        return new RecipeModel(recipe.getRecipeId(),
                recipe.getName(),
                recipe.getPortion(),
                recipe.getIngredients(),
                recipe.getSteps(),
                recipe.getImage(),
                recipe.getDescription());
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingStep() {
        return cookingStep;
    }

    public void setCookingStep(String cookingStep) {
        this.cookingStep = cookingStep;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipeName + '\'' +
                ", portion=" + portion +
                ", ingredients='" + ingredients + '\'' +
                ", cookingStep='" + cookingStep + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
