package com.recipe.se.recipes.infrastructure.user;

public class LoginResponse {

    private String name;
    private String message;
    private String error;

    public static LoginResponse emptyResponse() {
      return new LoginResponse("", "", "")  ;
    }

    public LoginResponse(String name, String message, String error) {
        this.name = name;
        this.message = message;
        this.error = error;
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
