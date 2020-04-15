package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.infrastructure.seller.SellerDetails;
import com.recipe.se.recipes.infrastructure.seller.SellerModel;

import java.util.List;

public interface SellerRepository {
    void addSeller(SellerDetails storePayload);

    List<SellerModel> fetchAllSellers();

    void deleteSellerById(String sellerId);

    void updateSellerById(String sellerId, SellerDetails sellerDetails);
}
