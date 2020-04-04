package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationPayload {

    @Email
    private String userName;

    @NotNull(message="Password cannot be missing or empty")
    @Size(min=6,  message="Password must not be less than 6 characters")
    private String password;

    private String firstName;

    private String lastName;

    @NotNull(message="Phone Number cannot be missing or empty")
    @Size(min=9, message="Phone number must not be less than 9 characters")
    private String phoneNumber;

    @JsonCreator
    public RegistrationPayload(@JsonProperty("userName") String userName, @JsonProperty("password") String password,
                               @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("phoneNumber") String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
