package com.recipe.se.recipes.domain.recipe;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.h2.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.RecipeDetails;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.RecipeModel;
import com.recipe.se.recipes.infrastructure.seller.h2store.Seller;
import com.recipe.se.recipes.infrastructure.seller.h2store.DatabaseSellerRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class H2FileRecipeRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;
    private final DatabaseSellerRepository databaseStoreRepository;

    public H2FileRecipeRepository(DatabaseRecipeRepository databaseRepository, DatabaseSellerRepository databaseStoreRepository) {
        this.databaseRepository = databaseRepository;
        this.databaseStoreRepository = databaseStoreRepository;
    }

    @Override
    public void addRecipes(RecipeDetails recipeDetails) throws StoreNotFoundException {
        //Set<DatabaseStore> databaseStores = getStoreById(recipeDetails);
        Recipe databaseRecipe = Recipe.convertToRecipe(recipeDetails);
        databaseRepository.save(databaseRecipe);
    }


    private Set<Seller> getStoreById(RecipeDetails recipe) throws StoreNotFoundException {
        Set<Seller> databaseStores = new HashSet<>();
        //get all the stores from the storeId which is inside our payload

        Set<String> storeIds = Collections.emptySet();

        //iterate all the storeId and fetch all the store based on storeId
        for (String storeId : storeIds) {

            Optional<Seller> store = databaseStoreRepository.findById(storeId);
            if (!store.isPresent()) {
                throw new StoreNotFoundException("Store is not available");
            }
            databaseStores.add(store.get());

        }

        return databaseStores;
    }

    @Override
    public List<RecipeModel> fetchAllRecipes() {
        List<RecipeModel> recipesList = new ArrayList<>();
        Iterable<Recipe> recipes = databaseRepository.findAll();
        for (Recipe recipe : recipes) {
           recipesList.add(RecipeModel.convertToRecipe(recipe));
        }
        return recipesList;
    }


    @Override
    public RecipeModel fetchRecipeById(String recipeId) throws RecipeNotFoundException {

        Optional<Recipe> databaseRecipe = databaseRepository.findById(recipeId);
        if (!databaseRecipe.isPresent()) {
            throw new RecipeNotFoundException("Recipe is not available");
        }

        return RecipeModel.convertToRecipe(databaseRecipe.get());
    }

    @Override
    public void deleteRecipeById(String recipeId) {

        databaseRepository.deleteById(recipeId);
    }


    @Override
    public void updateRecipe(String recipeId, RecipeDetails recipeDetails) throws RecipeNotFoundException {

        Optional<Recipe> databaseRecipe = databaseRepository.findById(recipeId);
        if (!databaseRecipe.isPresent()) {
            throw new RecipeNotFoundException("Recipe Not found exception");
        }
        Recipe recipeNeedsTobeUpdated = databaseRecipe.get();

        recipeNeedsTobeUpdated.setName(null != recipeDetails.getRecipeName() ? recipeDetails.getRecipeName() : recipeNeedsTobeUpdated.getName());
        recipeNeedsTobeUpdated.setType(null != recipeDetails.getType() ? recipeDetails.getType() : recipeNeedsTobeUpdated.getType());
        recipeNeedsTobeUpdated.setImage(null != recipeDetails.getImage() ? recipeDetails.getImage() : recipeNeedsTobeUpdated.getImage());
        recipeNeedsTobeUpdated.setDescription(null != recipeDetails.getDescription() ? recipeDetails.getDescription() : recipeNeedsTobeUpdated.getDescription());
        recipeNeedsTobeUpdated.setSteps(null != recipeDetails.getCookingStep() ? recipeDetails.getCookingStep() : recipeNeedsTobeUpdated.getSteps());
        recipeNeedsTobeUpdated.setPortion(recipeDetails.getPortion());
        recipeNeedsTobeUpdated.setIngredients(null != recipeDetails.getIngredients() ? recipeDetails.getIngredients() : recipeNeedsTobeUpdated.getIngredients());
        databaseRepository.save(recipeNeedsTobeUpdated);
    }

    @Override
    public List<RecipeModel> fetchByStore(String storeId) {
        throw new NotImplementedException();

    }

    @Override
    public List<RecipeModel> findRecipeBy(String searchTerm) {
        List<RecipeModel> recipesByNames = new ArrayList<>();
        List<Recipe> databaseRecipes = databaseRepository.findByName(searchTerm);
        for (Recipe databaseRecipe : databaseRecipes) {
            //recipesByNames.add(RecipeModel.convertToRecipe(databaseRecipe));
        }
        return recipesByNames;
    }
}



