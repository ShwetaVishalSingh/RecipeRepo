package com.recipe.se.recipes.domain.store;


import com.recipe.se.recipes.infrastructure.seller.SellerDetails;
import com.recipe.se.recipes.infrastructure.seller.SellerModel;
import com.recipe.se.recipes.infrastructure.seller.h2store.DatabaseSellerRepository;
import com.recipe.se.recipes.infrastructure.seller.h2store.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerH2DatabaseRepository implements SellerRepository {
    private final DatabaseSellerRepository databaseRepository;

    public SellerH2DatabaseRepository(DatabaseSellerRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }


    @Override
    public void addSeller(SellerDetails sellerDetails) {

        Seller databaseStore = Seller.convertToSeller(sellerDetails);
        databaseRepository.save(databaseStore);

    }

    @Override
    public List<SellerModel> fetchAllSellers() {
        List<SellerModel> sellers= new ArrayList<>();
     Iterable <Seller> result = databaseRepository.findAll();
        for (Seller seller:result)
        {
            sellers.add(SellerModel.convertToSellerModel(seller));
        }
        return sellers;
    }

    @Override
    public void deleteSellerById(String storeId) {
        databaseRepository.deleteById(storeId);
    }

    @Override
    public void updateSellerById(String sellerId, SellerDetails sellerDetails) {
        Seller databaseSellerNeededToUpdate = databaseRepository.findById(sellerId).get();
        databaseSellerNeededToUpdate.setName(sellerDetails.getName());
        databaseSellerNeededToUpdate.setEmail(sellerDetails.getEmail());
        databaseSellerNeededToUpdate.setAddress(sellerDetails.getAddress());
        databaseSellerNeededToUpdate.setCity(sellerDetails.getCity());
        databaseSellerNeededToUpdate.setImage(sellerDetails.getImage());
        databaseSellerNeededToUpdate.setPhone(sellerDetails.getPhone());
        databaseSellerNeededToUpdate.setPostalCode(sellerDetails.getPostalCode());
        databaseSellerNeededToUpdate.setState(sellerDetails.getState());

        databaseRepository.save(databaseSellerNeededToUpdate);
    }

}
