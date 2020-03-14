package com.recipe.se.recipes.domain;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String e) {
        super(e);
    }
}
