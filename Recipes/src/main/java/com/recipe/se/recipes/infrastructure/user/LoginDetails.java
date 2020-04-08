package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDetails {
    @Email
    private String userName;

    @NotNull(message="Password cannot be missing or empty")
    @Size(min=6,  message="Password must not be less than 6 characters")
    private String password;

    @JsonCreator
    public LoginDetails(@JsonProperty("userName") String userName, @JsonProperty("password") String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
