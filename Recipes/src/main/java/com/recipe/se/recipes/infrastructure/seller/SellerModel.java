package com.recipe.se.recipes.infrastructure.seller;

import com.recipe.se.recipes.infrastructure.seller.h2store.Seller;

public class SellerModel {
    private String id;
    private String name;
    private String city ;
    private String address;
    private String state;
    private String postalCode;
    private String image;
    private String phone;
    private String email;

    public static SellerModel convertToSellerModel(Seller seller) {
        return new SellerModel(seller.getId(),seller.getName(),seller.getCity(),seller.getAddress(),seller.getState(),seller.getPostalCode(),
                seller.getImage(),seller.getPhone(),seller.getEmail());
    }

    public SellerModel(String id, String name, String city, String address, String state, String postalCode, String image, String phone, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.state = state;
        this.postalCode = postalCode;
        this.image = image;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SellerModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
