package com.recipe.se.recipes.domain;

import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipe;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class InMemoryDatabaseRepositoryTest {

    @Test
    void shouldReturnRecipe() {
        //given
        DatabaseRecipe expectedRecipe = new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet());

        String recipeId = "123";
        DatabaseRecipeRepository recipeRepository = mock(DatabaseRecipeRepository.class);
        DatabaseStoreRepository storeRepository = mock(DatabaseStoreRepository.class);


        given(recipeRepository.findById(recipeId)).willReturn(Optional.of(new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet())));

        //when

        Recipe actualRecipe = new InMemoryDatabaseRepository(recipeRepository, storeRepository).fetchRecipeById(recipeId);

        //then
        assertEquals(expectedRecipe.getRecipeName(), actualRecipe.getRecipeName());
    }

    @Test
    void shouldThrowExceptionWhenRecipeIsNotAvailable() {
        //given

        String recipeId = "123";
        DatabaseRecipeRepository recipeRepository = mock(DatabaseRecipeRepository.class);
        DatabaseStoreRepository storeRepository = mock(DatabaseStoreRepository.class);


        given(recipeRepository.findById(recipeId)).willReturn(Optional.empty());

        //when



        //then
        Assertions.assertThrows(RecipeNotFoundException.class, () -> {
            new InMemoryDatabaseRepository(recipeRepository, storeRepository).fetchRecipeById(recipeId);
        });

    }
}
