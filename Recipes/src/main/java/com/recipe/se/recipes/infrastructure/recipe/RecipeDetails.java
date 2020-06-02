package com.recipe.se.recipes.infrastructure.recipe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeDetails {
    private String recipeName;
    private int portion;
    private String ingredients;
    private String cookingStep;
    private String image;
    private String description;
    private String type;
    private String sellerId;
    private boolean enabled;


    @JsonCreator
    public RecipeDetails(@JsonProperty("recipeName") String recipeName,
                         @JsonProperty("portion") int portion,
                         @JsonProperty("ingredients") String ingredients,
                         @JsonProperty("cookingStep") String cookingStep,
                         @JsonProperty("recipeImage") String image,
                         @JsonProperty("description") String description,
                         @JsonProperty("sellerId") String sellerId,
                         @JsonProperty("type") String type,
                         @JsonProperty("enabled")  boolean enabled) {

        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
        this.cookingStep = cookingStep;
        this.description = description;
        this.image = image;
        this.type = type;
        this.sellerId = sellerId;
        this.enabled= enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RecipeDetails{" +
                "recipeName='" + recipeName + '\'' +
                ", portion=" + portion +
                ", ingredients='" + ingredients + '\'' +
                ", cookingStep='" + cookingStep + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
