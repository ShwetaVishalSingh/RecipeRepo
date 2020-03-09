package com.recipe.se.recipes.infrastructure.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;

public class Store {
    private String storeId;
    private String storeName;
    private String storeCity ;
    private String storeOwner;

    @JsonCreator
    public Store(@JsonProperty("storeId") String storeId, @JsonProperty("storeName")  String storeName,
                 @JsonProperty("storeCity") String storeCity, @JsonProperty("storeOwner") String storeOwner) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeCity = storeCity;
        this.storeOwner = storeOwner;
    }



    public static Store convertToStore(DatabaseStore databaseStore) {
        return new Store(databaseStore.getStoreId(), databaseStore.getStoreName(), databaseStore.getStoreCity(), databaseStore.getStoreOwner());

    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeCity='" + storeCity + '\'' +
                ", storeOwner='" + storeOwner + '\'' +
                '}';
    }
}
