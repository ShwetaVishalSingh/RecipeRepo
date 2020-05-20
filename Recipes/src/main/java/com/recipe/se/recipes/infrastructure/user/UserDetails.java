package com.recipe.se.recipes.infrastructure.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {

    private String firstName;
    private String lastName;
    private String phoneNo;


    @JsonCreator
    public UserDetails(@JsonProperty("firstName") String firstName,

                        @JsonProperty("lastName") String lastName,
                         @JsonProperty("phoneNo") String phoneNo) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
