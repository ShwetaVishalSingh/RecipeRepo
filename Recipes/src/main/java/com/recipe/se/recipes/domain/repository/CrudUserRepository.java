package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface CrudUserRepository extends CrudRepository<User,String> {
}
