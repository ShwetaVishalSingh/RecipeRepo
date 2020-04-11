package com.recipe.se.recipes.domain.recipe;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Payload;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;

import java.util.*;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;
    private final DatabaseStoreRepository databaseStoreRepository;

    public InMemoryDatabaseRepository(DatabaseRecipeRepository databaseRepository, DatabaseStoreRepository databaseStoreRepository) {
        this.databaseRepository = databaseRepository;
        this.databaseStoreRepository = databaseStoreRepository;
    }

    @Override
    public void addRecipes(Payload recipe) throws StoreNotFoundException {
        Set<DatabaseStore> databaseStores = getStoreById(recipe);
        DatabaseRecipe databaseRecipe = DatabaseRecipe.convertToDatabaseRecipe(recipe.getUserRecipe(), databaseStores);
        databaseRepository.save(databaseRecipe);
    }


    private Set<DatabaseStore> getStoreById(Payload recipe) throws StoreNotFoundException {
        Set<DatabaseStore> databaseStores = new HashSet<>();
        //get all the stores from the storeId which is inside our payload

        Set<String> storeIds = recipe.getUserRecipe().getStoreIds();

        //iterate all the storeId and fetch all the store based on storeId
        for (String storeId : storeIds) {

            Optional<DatabaseStore> store = databaseStoreRepository.findById(storeId);
            if (!store.isPresent()) {
                throw new StoreNotFoundException("Store is not available");
            }
            databaseStores.add(store.get());

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
    public Recipe fetchRecipeById(String recipeId) throws RecipeNotFoundException {

        Optional<DatabaseRecipe> databaseRecipe = databaseRepository.findById(recipeId);
        if (!databaseRecipe.isPresent()) {
            throw new RecipeNotFoundException("Recipe is not available");
        }

        return Recipe.convertToRecipe(databaseRecipe.get());
    }

    @Override
    public void deleteRecipeById(String recipeId) {

        databaseRepository.deleteById(recipeId);
    }


    @Override
    public void updateRecipe(String recipeId, Payload paylaod) throws RecipeNotFoundException {

        Optional<DatabaseRecipe> databaseRecipe = databaseRepository.findById(recipeId);
        if (!databaseRecipe.isPresent()) {
            throw new RecipeNotFoundException("Recipe Not found exception");
        }
        DatabaseRecipe recipeNeedsTobeUpdated = databaseRecipe.get();
        Set<DatabaseStore> databaseStores = getStoreById(paylaod);

        recipeNeedsTobeUpdated.setRecipeName(null != paylaod.getUserRecipe().getRecipeName() ? paylaod.getUserRecipe().getRecipeName() : recipeNeedsTobeUpdated.getRecipeName());
        recipeNeedsTobeUpdated.setPortion(null != paylaod.getUserRecipe().getPortion() ? paylaod.getUserRecipe().getPortion() : recipeNeedsTobeUpdated.getPortion());
        recipeNeedsTobeUpdated.setIngredients(null != paylaod.getUserRecipe().getIngredients() ? DatabaseRecipe.toDatabaseIngredients(paylaod.getUserRecipe().getIngredients()) : recipeNeedsTobeUpdated.getIngredients());
        recipeNeedsTobeUpdated.setDatabaseStores(null != paylaod.getUserRecipe().getStoreIds() ? databaseStores : recipeNeedsTobeUpdated.getDatabaseStores());
        databaseRepository.save(recipeNeedsTobeUpdated);
    }

    @Override
    public List<Recipe> fetchByStore(String storeId) {
        List<Recipe> recipes = new ArrayList<>();
        Iterable<DatabaseRecipe> databaseRecipes = databaseRepository.findAll();
        for (DatabaseRecipe databaseRecipe : databaseRecipes) {
            Set<DatabaseStore> databaseStores = databaseRecipe.getDatabaseStores();
            for (DatabaseStore databaseStore : databaseStores)
                if (databaseStore.getStoreId().equals(storeId)) {
                    recipes.add(Recipe.convertToRecipe(databaseRecipe));
                }


        }
        return recipes;

    }

    @Override
    public List<Recipe> findRecipeBy(String searchTerm) {
        List<Recipe> recipesByNames = new ArrayList<>();
        List<DatabaseRecipe> databaseRecipes = databaseRepository.findByName(searchTerm);
        for (DatabaseRecipe databaseRecipe : databaseRecipes) {
            recipesByNames.add(Recipe.convertToRecipe(databaseRecipe));
        }
        return recipesByNames;
    }
}



