package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domain.store.SellerRepository;
import com.recipe.se.recipes.infrastructure.seller.SellerDetails;
import com.recipe.se.recipes.infrastructure.seller.SellerModel;

import java.util.List;

public class SellerService {
    private SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void addSeller(SellerDetails sellerDetails) {
        sellerRepository.addSeller(sellerDetails);
    }

    public List<SellerModel> fetchAllSeller()
    {
       return  sellerRepository.fetchAllSellers();
    }

    public void deleteSellerById(String sellerId) {
        sellerRepository.deleteSellerById(sellerId);
    }

    public void updateSellerById(String sellerId, SellerDetails sellerDetails) {
        sellerRepository.updateSellerById(sellerId,sellerDetails);
    }
}
