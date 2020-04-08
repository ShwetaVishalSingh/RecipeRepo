package com.recipe.se.recipes.domain.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String e) {
        super(e);
    }
}
