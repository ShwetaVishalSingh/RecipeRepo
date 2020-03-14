package com.recipe.se.recipes.infrastructure.recipe.h2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DatabaseRecipeRepository extends CrudRepository<DatabaseRecipe, String> {
    @Query(value = "SELECT * FROM RECIPE rp WHERE rp.RECIPE_NAME LIKE %?1%", nativeQuery = true)
   List<DatabaseRecipe> findByName(String searchTerm);
}
