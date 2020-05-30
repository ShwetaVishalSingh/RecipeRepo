package com.recipe.se.recipes.infrastructure.user;

public class UserUpdateModel {

    private String message;
    private String errorMessage;

    public UserUpdateModel(String message, String errorMessage) {
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setError(String error) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


