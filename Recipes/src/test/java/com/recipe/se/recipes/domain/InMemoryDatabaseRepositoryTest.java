package com.recipe.se.recipes.domain;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.recipe.H2FileRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.h2.Recipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.RecipeModel;
import com.recipe.se.recipes.infrastructure.seller.h2store.DatabaseSellerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class InMemoryDatabaseRepositoryTest {

    @Test
    void shouldReturnRecipe() {
        //given
       // DatabaseRecipe expectedRecipe = new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet());
        Recipe expectedRecipe = null;

        String recipeId = "123";
        DatabaseRecipeRepository recipeRepository = mock(DatabaseRecipeRepository.class);
        DatabaseSellerRepository storeRepository = mock(DatabaseSellerRepository.class);


        //given(recipeRepository.findById(recipeId)).willReturn(Optional.of(new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet())));

        //when

        RecipeModel actualRecipe = new H2FileRecipeRepository(recipeRepository, storeRepository).fetchRecipeById(recipeId);

        //then
       // assertEquals(expectedRecipe.getRecipeName(), actualRecipe.getRecipeName());
    }

    @Test
    void shouldThrowExceptionWhenRecipeIsNotAvailable() {
        //given

        String recipeId = "123";
        DatabaseRecipeRepository recipeRepository = mock(DatabaseRecipeRepository.class);
        DatabaseSellerRepository storeRepository = mock(DatabaseSellerRepository.class);


        given(recipeRepository.findById(recipeId)).willReturn(Optional.empty());

        //when



        //then
        Assertions.assertThrows(RecipeNotFoundException.class, () -> {
            new H2FileRecipeRepository(recipeRepository, storeRepository).fetchRecipeById(recipeId);
        });

    }
}
