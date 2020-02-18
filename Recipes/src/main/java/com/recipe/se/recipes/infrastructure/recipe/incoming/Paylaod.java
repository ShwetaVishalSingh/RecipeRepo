package com.recipe.se.recipes.infrastructure.recipe.incoming;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paylaod {
    private Recipe recipe;

    @JsonCreator
    public Paylaod(@JsonProperty("recipe") Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getUserRecipe() {
        return recipe;
    }
}
