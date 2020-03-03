package com.recipe.se.recipes.infrastructure.recipe.h2;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseRecipeRepository extends CrudRepository<DatabaseRecipe, String> {

}
