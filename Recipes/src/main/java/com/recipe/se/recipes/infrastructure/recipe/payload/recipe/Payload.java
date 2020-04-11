package com.recipe.se.recipes.infrastructure.recipe.payload.recipe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {
    private Recipe recipe;

    @JsonCreator
    public Payload(@JsonProperty("recipe") Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getUserRecipe() {
        return recipe;
    }
}
