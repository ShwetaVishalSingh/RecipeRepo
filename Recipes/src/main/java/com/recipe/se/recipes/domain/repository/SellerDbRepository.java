package com.recipe.se.recipes.domain.repository;


import com.recipe.se.recipes.domain.seller.Seller;
import com.recipe.se.recipes.infrastructure.seller.SellerDetails;
import com.recipe.se.recipes.infrastructure.seller.SellerModel;

import java.util.ArrayList;
import java.util.List;

public class SellerDbRepository implements SellerRepository {
    private final CrudSellerRepository databaseRepository;

    public SellerDbRepository(CrudSellerRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }


    @Override
    public void addSeller(SellerDetails sellerDetails) {

        Seller seller = Seller.convertToSeller(sellerDetails);
        databaseRepository.save(seller);

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
    public void deleteSellerById(String sellerId) {
        databaseRepository.deleteById(sellerId);
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
