package com.recipe.se.recipes.domain;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String e) {
        super(e);
    }
}
