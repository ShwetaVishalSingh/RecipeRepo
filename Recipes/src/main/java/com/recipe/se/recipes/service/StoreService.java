package com.recipe.se.recipes.service;

import com.recipe.se.recipes.business.domain.store.StoreRepository;
import com.recipe.se.recipes.infrastructure.store.Store;
import com.recipe.se.recipes.infrastructure.store.StorePayload;

import java.util.List;

public class StoreService {
    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void addStore(StorePayload storePayload) {
        storeRepository.addStore(storePayload);
    }

    public List<Store> fetchAllStores()
    {
       return  storeRepository.fetchAllStores();
    }

    public void deleteStoreById(String storeId) {
        storeRepository.deleteStoreById(storeId);
    }

    public void updateStoreById(String storeId, StorePayload storePayload) {
        storeRepository.updateStoreById(storeId,storePayload);
    }
}
