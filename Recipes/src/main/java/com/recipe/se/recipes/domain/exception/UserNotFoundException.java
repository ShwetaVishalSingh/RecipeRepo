package com.recipe.se.recipes.domain.exception;

public class UserNotFoundException extends RuntimeException  {

    public UserNotFoundException(String e) {
        super(e);
    }
}
