package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.recipe.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudRecipeRepository extends CrudRepository<Recipe, String> {
    @Query(value = "SELECT * FROM RECIPE rp WHERE rp.RECIPE_NAME LIKE %?1%", nativeQuery = true)
   List<Recipe> findByName(String searchTerm);
}
