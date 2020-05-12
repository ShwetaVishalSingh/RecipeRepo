package com.recipe.se.recipes.infrastructure.user;

import com.recipe.se.recipes.domain.user.User;

public class UserModel {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;


    public UserModel(String userName, String firstName, String lastName, String password, String  phoneNumber) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UserModel() {

    }

    public static UserModel convertToUser(User user) {
        return new UserModel(user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getPhoneNumber());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", firstName=" + firstName +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
