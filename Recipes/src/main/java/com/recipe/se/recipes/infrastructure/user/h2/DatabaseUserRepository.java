package com.recipe.se.recipes.infrastructure.user.h2;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseUserRepository extends CrudRepository<UserDatabase,String> {
}
