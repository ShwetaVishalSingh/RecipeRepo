package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.payload.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.payload.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;

    public InMemoryDatabaseRepository(DatabaseRecipeRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public void addRecipes(Paylaod recipe) {

        DatabaseRecipe databaseRecipe = DatabaseRecipe.convertToDatabaseRecipe(recipe.getUserRecipe());
        databaseRepository.save(databaseRecipe);
    }


    @Override
    public List<Recipe> fetchAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Iterable<DatabaseRecipe> databaseRecipes = databaseRepository.findAll();
        for(DatabaseRecipe databaseRecipe : databaseRecipes){
            recipes.add(Recipe.convertToRecipe(databaseRecipe));
        }
        return recipes;
    }



    @Override
    public Recipe fetchRecipeById(String recipeId) throws Exception {

        DatabaseRecipe databaseRecipe = null;

            databaseRecipe = databaseRepository.findById(recipeId).get();
            if(databaseRecipe == null)
            {
                throw new Exception("Recipe is null");
            }


        return Recipe.convertToRecipe(databaseRecipe);
    }

    @Override
    public void deleteRecipeById(String recipeId) {

         databaseRepository.deleteById(recipeId);
    }



    @Override
    public void updateRecipe(String recipeId, Paylaod paylaod) throws Exception {

        DatabaseRecipe recipeNeedsTobeUpdated = databaseRepository.findById(recipeId).get();
        if(recipeNeedsTobeUpdated == null){
            throw new Exception("Recipe is null");
        }
        recipeNeedsTobeUpdated.setRecipeName(paylaod.getUserRecipe().getRecipeName());
        recipeNeedsTobeUpdated.setPortion(paylaod.getUserRecipe().getPortion());
        recipeNeedsTobeUpdated.setIngredients(DatabaseRecipe.toDatabaseIngredients(paylaod.getUserRecipe().getIngredients()));
        databaseRepository.save(recipeNeedsTobeUpdated);
    }
}
