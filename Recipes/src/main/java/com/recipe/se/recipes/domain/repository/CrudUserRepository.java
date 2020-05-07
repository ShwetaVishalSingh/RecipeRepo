package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudUserRepository extends CrudRepository<User,String> {

    @Query(value = "SELECT * FROM USERS rp WHERE rp.ID= ?1", nativeQuery = true)
    Optional<User> findByUserId(String Id);
}
