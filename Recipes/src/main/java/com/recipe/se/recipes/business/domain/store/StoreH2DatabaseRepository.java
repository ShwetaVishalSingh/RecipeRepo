package com.recipe.se.recipes.business.domain.store;


import com.recipe.se.recipes.infrastructure.store.Store;
import com.recipe.se.recipes.infrastructure.store.StorePayload;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;

import java.util.ArrayList;
import java.util.List;

public class StoreH2DatabaseRepository implements StoreRepository {
    private final DatabaseStoreRepository databaseRepository;

    public StoreH2DatabaseRepository(DatabaseStoreRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }


    @Override
    public void addStore(StorePayload storePayload) {
        /*DatabaseStore store = new DatabaseStore();
        DatabaseStore databaseStore = store.convertToDatabaseStore(storePayload.getStore());
       DatabaseStore databaseStore = new DatabaseStore(storePayload.getStore().getStoreId(), storePayload.getStore().getStoreName(), storePayload.getStore().getStoreCity(),
               storePayload.getStore().getStoreOwner());*/
        DatabaseStore databaseStore = DatabaseStore.convertToDatabaseStore(storePayload.getStore());
        databaseRepository.save(databaseStore);

    }

    @Override
    public List<Store> fetchAllStores() {
        List<Store> stores= new ArrayList<>();
     Iterable <DatabaseStore> databaseStore = databaseRepository.findAll();
        for (DatabaseStore dbStore:databaseStore)
        {
            stores.add(Store.convertToStore(dbStore));
        }
        return stores;
    }

    @Override
    public void deleteStoreById(String storeId) {
        databaseRepository.deleteById(storeId);
    }

    @Override
    public void updateStoreById(String storeId, StorePayload storePayload) {
        DatabaseStore databaseStoreNeededToUpdate = databaseRepository.findById(storeId).get();
        databaseStoreNeededToUpdate.setStoreName(storePayload.getStore().getStoreName());
        databaseStoreNeededToUpdate.setStoreCity(storePayload.getStore().getStoreCity());
        databaseStoreNeededToUpdate.setStoreOwner(storePayload.getStore().getStoreOwner());
        databaseRepository.save(databaseStoreNeededToUpdate);
    }

}
