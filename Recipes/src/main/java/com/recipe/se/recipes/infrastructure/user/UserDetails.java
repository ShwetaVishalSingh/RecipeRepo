package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {

    private String firstName;
    private String lastName;
    private String phoneNumber;


    @JsonCreator
    public UserDetails(@JsonProperty("firstName") String firstName,

                        @JsonProperty("lastName") String lastName,
                         @JsonProperty("phoneNumber") String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

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
