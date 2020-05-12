package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePassword {

    private String id;
    private String oldPassword;


    @NotNull(message="Password cannot be missing or empty")
    @Size(min=6,  message="Password must not be less than 6 characters")
    private String newPassword;

    private String confirmPassword;

    @JsonCreator
    public ChangePassword(@JsonProperty("id") String id, @JsonProperty("oldPassword") String oldPasssword, @JsonProperty("newPassword") String newPassword, @JsonProperty("confirmPassword") String confirmPasssword){
        this.id =id;
        this.oldPassword = oldPasssword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPasssword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
