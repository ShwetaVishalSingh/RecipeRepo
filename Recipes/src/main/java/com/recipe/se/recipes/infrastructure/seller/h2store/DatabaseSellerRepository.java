package com.recipe.se.recipes.infrastructure.seller.h2store;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseSellerRepository extends CrudRepository<Seller,String>{
}
