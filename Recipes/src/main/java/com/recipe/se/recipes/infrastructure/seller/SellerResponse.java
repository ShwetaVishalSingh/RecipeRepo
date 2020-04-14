package com.recipe.se.recipes.infrastructure.seller;

import java.util.List;

public class SellerResponse {
     private List<SellerModel> sellers;

    public List<SellerModel> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerModel> sellers) {
        this.sellers = sellers;
    }
}
