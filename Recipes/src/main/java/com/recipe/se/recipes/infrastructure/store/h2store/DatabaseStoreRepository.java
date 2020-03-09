package com.recipe.se.recipes.infrastructure.store.h2store;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseStoreRepository extends CrudRepository<DatabaseStore,String>{
}
