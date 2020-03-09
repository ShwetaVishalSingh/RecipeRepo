package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;
    private final DatabaseStoreRepository databaseStoreRepository;

    public InMemoryDatabaseRepository(DatabaseRecipeRepository databaseRepository, DatabaseStoreRepository databaseStoreRepository) {
        this.databaseRepository = databaseRepository;
        this.databaseStoreRepository = databaseStoreRepository;
    }

    @Override
    public void addRecipes(Paylaod recipe) {
        Set<DatabaseStore> databaseStores = getStoreById(recipe);

        DatabaseRecipe databaseRecipe = DatabaseRecipe.convertToDatabaseRecipe(recipe.getUserRecipe(), databaseStores);
        databaseRepository.save(databaseRecipe);
    }

   /* private Set<DatabaseStore> getStoreById(Paylaod recipe) {
        Set<DatabaseStore> databaseStores = new HashSet<>();
        Set<String> storeIds = recipe.getUserRecipe().getStoreIds();
        for (String storeId : storeIds) {
            DatabaseStore storeById;
            storeById = databaseStoreRepository.findById(storeId).get();
            databaseStores.add(storeById);
        }
        return databaseStores;
    }*/

   private Set<DatabaseStore> getStoreById(Paylaod recipe) {
        Set<DatabaseStore> databaseStores = new HashSet<>();
        //get all the stores from the storeId which is inside our payload

        Set<String> storeIds = recipe.getUserRecipe().getStoreIds();

        //iterate all the storeId and fetch all the store based on storeId
        for (String storeId : storeIds) {
            DatabaseStore storeById = databaseStoreRepository.findById(storeId).get();
            databaseStores.add(storeById);
        }

        return databaseStores;
    }

    @Override
    public List<Recipe> fetchAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Iterable<DatabaseRecipe> databaseRecipes = databaseRepository.findAll();
        for (DatabaseRecipe databaseRecipe : databaseRecipes) {
            recipes.add(Recipe.convertToRecipe(databaseRecipe));
        }
        return recipes;
    }


    @Override
    public Recipe fetchRecipeById(String recipeId) throws Exception {

        DatabaseRecipe databaseRecipe = null;

        databaseRecipe = databaseRepository.findById(recipeId).get();
        if (databaseRecipe == null) {
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
        Set<DatabaseStore> databaseStores = getStoreById(paylaod);
        if (recipeNeedsTobeUpdated == null) {
            throw new Exception("Recipe is null");
        }
        recipeNeedsTobeUpdated.setRecipeName(null != paylaod.getUserRecipe().getRecipeName() ? paylaod.getUserRecipe().getRecipeName() : recipeNeedsTobeUpdated.getRecipeName());
        recipeNeedsTobeUpdated.setPortion(null != paylaod.getUserRecipe().getPortion() ? paylaod.getUserRecipe().getPortion() : recipeNeedsTobeUpdated.getPortion());
        recipeNeedsTobeUpdated.setIngredients(null != paylaod.getUserRecipe().getIngredients() ? DatabaseRecipe.toDatabaseIngredients(paylaod.getUserRecipe().getIngredients()) : recipeNeedsTobeUpdated.getIngredients());
        recipeNeedsTobeUpdated.setDatabaseStores(null != paylaod.getUserRecipe().getStoreIds() ? databaseStores : recipeNeedsTobeUpdated.getDatabaseStores());
        databaseRepository.save(recipeNeedsTobeUpdated);
    }

}



