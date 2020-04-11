package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewPassword {

    @Email
    private String userName;
    private String oldPassword;


    @NotNull(message="Password cannot be missing or empty")
    @Size(min=6,  message="Password must not be less than 6 characters")
    private String newPassword;

    private String confirmPassword;

    @JsonCreator
    public NewPassword(@JsonProperty("userName") String userName,@JsonProperty("oldPassword") String oldPasssword, @JsonProperty("newPassword") String newPassword,@JsonProperty("confirmPassword") String confirmPasssword){
        this.userName =userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
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
