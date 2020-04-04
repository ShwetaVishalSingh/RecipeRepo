package com.recipe.se.recipes.business.domain.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String e) {
        super(e);
    }
}
