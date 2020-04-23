package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.exception.StoreNotFoundException;
import com.recipe.se.recipes.domain.recipe.Recipe;
import com.recipe.se.recipes.domain.seller.Seller;
import com.recipe.se.recipes.infrastructure.recipe.RecipeDetails;
import com.recipe.se.recipes.infrastructure.recipe.RecipeModel;

import java.util.*;

public class RecipeDbRepository implements RecipeRepository {

    private final CrudRecipeRepository databaseRepository;

    public RecipeDbRepository(CrudRecipeRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public void addRecipes(RecipeDetails recipeDetails) throws StoreNotFoundException {
        //Set<DatabaseStore> databaseStores = getStoreById(recipeDetails);
        Recipe databaseRecipe = Recipe.convertToRecipe(recipeDetails);
        databaseRepository.save(databaseRecipe);
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
    public List<RecipeModel> fetchBySeller(String sellerId) {
        List<RecipeModel> recipeBySellerId = new ArrayList<>();
       List <Recipe> databaseRecipes  = databaseRepository.findBySellerId(sellerId);
        for (Recipe databaseRecipe: databaseRecipes) {
             recipeBySellerId.add(RecipeModel.convertToRecipe(databaseRecipe));

        }
      return recipeBySellerId;

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



