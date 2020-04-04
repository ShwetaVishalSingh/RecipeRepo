package com.recipe.se.recipes.business.domain.store;

import com.recipe.se.recipes.infrastructure.store.Store;
import com.recipe.se.recipes.infrastructure.store.StorePayload;

import java.util.List;

public interface StoreRepository {
    void addStore(StorePayload storePayload);

    List<Store> fetchAllStores();

    void deleteStoreById(String storeId);

    void updateStoreById(String storeId, StorePayload storePayload);
}
