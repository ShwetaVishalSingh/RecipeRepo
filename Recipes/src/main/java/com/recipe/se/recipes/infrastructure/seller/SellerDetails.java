package com.recipe.se.recipes.infrastructure.seller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.se.recipes.infrastructure.seller.h2store.Seller;
import org.apache.catalina.Store;

public class SellerDetails {
    private String id;
    private String name;
    private String city ;
    private String address;
    private String state;
    private String postalCode;
    private String image;
    private String phone;
    private String email;

    @JsonCreator
    public SellerDetails(@JsonProperty("id") String id,
                 @JsonProperty("name") String name,
                 @JsonProperty("city") String city,
                 @JsonProperty("address") String address,
                 @JsonProperty("postalCode") String postalCode,
                 @JsonProperty("state")  String state,
                 @JsonProperty("image") String image,
                 @JsonProperty("phone") String phone,
                 @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.state = state;
        this.image = image;
        this.email = email;
        this.phone = phone;

    }



    public static Store convertToStore(Seller databaseStore) {
        //return new Store(databaseStore.getStoreId(), databaseStore.getStoreName(), databaseStore.getStoreCity(), databaseStore.getStoreOwner());
        return  null;

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
        return "SellerDetails{" +
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

