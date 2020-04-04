package com.recipe.se.recipes.business.domain.exception;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String e) {
        super(e);
    }
}
