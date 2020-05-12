package com.recipe.se.recipes.infrastructure.user;

public class LoginResponse {

    private String id;
    private String name;
    private String message;
    private String error;


    public LoginResponse(String id, String name, String message, String error) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
