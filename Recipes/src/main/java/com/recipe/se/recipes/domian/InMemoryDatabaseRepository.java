package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipeRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final CrudRepository<DatabaseRecipe, String> databaseRepository;

    public InMemoryDatabaseRepository(CrudRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public List<DatabaseRecipe> fetchAllRecipes() {
         databaseRepository.findAll();
         return null;
    }

    @Override
    public DatabaseRecipe fetchRecipeById(String recipeId) {
        return null;
    }

    @Override
    public DatabaseRecipe deleteRecipeById(String recipeId) {
        return null;
    }

    @Override
    public void addRecipes(Paylaod paylaod) {
        //return recipeStateRepository.save(toRecipeState(paylaod));
        DatabaseRecipe databaseRecipe = DatabaseRecipe.of(paylaod.getUserRecipe());
        databaseRepository.save(databaseRecipe);
    }


    @Override
    public DatabaseRecipe updateRecipe(String recipeId, Paylaod paylaod) {
        return null;
    }
}
