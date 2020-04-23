package com.recipe.se.recipes.domain.seller;

import com.recipe.se.recipes.infrastructure.seller.SellerDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SELLER")
public class Seller {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "IMAGE", nullable = false)
    private String image;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    private String email;


    public Seller() {
    }

    public Seller(String id, String name, String city, String address, String state, String postalCode, String image, String phone, String email) {
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

    public static Seller convertToSeller(SellerDetails sellerDetails) {
        return new Seller(sellerDetails.getId(),sellerDetails.getName(),sellerDetails.getCity(),sellerDetails.getAddress(),sellerDetails.getState(),sellerDetails.getPostalCode(),
                sellerDetails.getImage(),sellerDetails.getPhone(),sellerDetails.getEmail());
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
}
