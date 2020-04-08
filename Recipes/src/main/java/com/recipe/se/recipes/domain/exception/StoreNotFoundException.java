package com.recipe.se.recipes.domain.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String e) {
        super(e);
    }
}
