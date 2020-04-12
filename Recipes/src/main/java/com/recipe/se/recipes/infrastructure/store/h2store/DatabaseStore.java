package com.recipe.se.recipes.infrastructure.store.h2store;

import com.recipe.se.recipes.infrastructure.store.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")
public class DatabaseStore {
    @Id
    @Column(name = "ID")
    private String storeId;

    @Column(name = "STORE_NAME", nullable = false)
    private String storeName;

    @Column(name = "STORE_CITY", nullable = false)
    private String storeCity;

  @Column (name="STORE_OWNER" , nullable = false)
    private String storeOwner;



    public DatabaseStore() {
    }

    public DatabaseStore(String storeId) {
        this.storeId = storeId;
    }


    public DatabaseStore(String storeId, String storeName, String storeCity, String storeOwner) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeCity = storeCity;
        this.storeOwner = storeOwner;
    }

    public static  DatabaseStore  convertToDatabaseStore(Store storePayload) {

        return new DatabaseStore(storePayload.getStoreId(),
                storePayload.getStoreName(),
                storePayload.getStoreCity(),
                storePayload.getStoreOwner());
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public String getStoreOwner() {
        return storeOwner;
    }
}
