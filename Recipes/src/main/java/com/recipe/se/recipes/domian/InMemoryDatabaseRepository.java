package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipeRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;

    public InMemoryDatabaseRepository(DatabaseRecipeRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public List<Recipe> fetchAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        Iterable<DatabaseRecipe> databaseRecipes = databaseRepository.findAll();
        for(DatabaseRecipe databaseRecipe : databaseRecipes){
            recipes.add(Recipe.of(databaseRecipe));
        }
        return recipes;
    }

    @Override
    public DatabaseRecipe fetchRecipeById(String recipeId) {
        return null;
    }

    @Override
    public void deleteRecipeById(String recipeId) {

         databaseRepository.deleteById(recipeId);
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
