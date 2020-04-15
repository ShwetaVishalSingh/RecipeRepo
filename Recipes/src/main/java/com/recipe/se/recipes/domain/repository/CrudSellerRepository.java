package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.seller.Seller;
import org.springframework.data.repository.CrudRepository;

public interface CrudSellerRepository extends CrudRepository<Seller,String>{
}
