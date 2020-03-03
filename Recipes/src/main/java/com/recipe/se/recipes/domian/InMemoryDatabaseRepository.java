package com.recipe.se.recipes.domian;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipeRepository;
import org.apache.commons.lang3.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseRepository implements RecipeRepository {

    private final DatabaseRecipeRepository databaseRepository;

    public InMemoryDatabaseRepository(DatabaseRecipeRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public List<Recipe> fetchAllRecipes() throws Exception{
        List<Recipe> recipes = new ArrayList<>();
        Iterable<DatabaseRecipe> databaseRecipes;
         databaseRecipes = databaseRepository.findAll();
        for(DatabaseRecipe databaseRecipe : databaseRecipes){
            recipes.add(Recipe.of(databaseRecipe));
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


        return Recipe.of(databaseRecipe);
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
    public void updateRecipe(String recipeId, Paylaod paylaod) throws Exception {

        DatabaseRecipe recipeNeedsTobeUpdated = databaseRepository.findById(recipeId).get();
        if(recipeNeedsTobeUpdated == null){
            throw new Exception("Recipe is null");
        }
        recipeNeedsTobeUpdated.setRecipeName(paylaod.getUserRecipe().getRecipeName());
        recipeNeedsTobeUpdated.setPortion(paylaod.getUserRecipe().getPortion());
        recipeNeedsTobeUpdated.setIngredients(StringUtils.join(paylaod.getUserRecipe().getIngredients(), '-'));
        databaseRepository.save(recipeNeedsTobeUpdated);
    }
}
