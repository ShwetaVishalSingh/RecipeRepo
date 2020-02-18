package com.recipe.se.recipes.infrastructure.recipe.outgoing;

import org.springframework.data.repository.CrudRepository;

public interface DatabaseRecipeRepository extends CrudRepository<DatabaseRecipe, String> {

}
