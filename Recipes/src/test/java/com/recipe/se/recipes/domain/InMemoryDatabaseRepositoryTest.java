package com.recipe.se.recipes.domain;

import com.recipe.se.recipes.domain.exception.RecipeNotFoundException;
import com.recipe.se.recipes.domain.repository.RecipeDbRepository;
import com.recipe.se.recipes.domain.recipe.Recipe;
import com.recipe.se.recipes.domain.repository.CrudRecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.RecipeModel;
import com.recipe.se.recipes.domain.repository.CrudSellerRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
@Ignore
class InMemoryDatabaseRepositoryTest {

    @Ignore
    void shouldReturnRecipe() {
        //given
       // DatabaseRecipe expectedRecipe = new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet());
        Recipe expectedRecipe = null;

        String recipeId = "123";
        CrudRecipeRepository recipeRepository = mock(CrudRecipeRepository.class);
        CrudSellerRepository storeRepository = mock(CrudSellerRepository.class);


        //given(recipeRepository.findById(recipeId)).willReturn(Optional.of(new DatabaseRecipe("123", "abc", "1", Collections.emptySet(), Collections.emptySet())));

        //when

        RecipeModel actualRecipe = new RecipeDbRepository(recipeRepository).fetchRecipeById(recipeId);

        //then
       // assertEquals(expectedRecipe.getRecipeName(), actualRecipe.getRecipeName());
    }

    @Ignore
    void shouldThrowExceptionWhenRecipeIsNotAvailable() {
        //given

        String recipeId = "123";
        CrudRecipeRepository recipeRepository = mock(CrudRecipeRepository.class);
        CrudSellerRepository storeRepository = mock(CrudSellerRepository.class);


        given(recipeRepository.findById(recipeId)).willReturn(Optional.empty());

        //when



        //then
        Assertions.assertThrows(RecipeNotFoundException.class, () -> {
            new RecipeDbRepository(recipeRepository).fetchRecipeById(recipeId);
        });

    }
}
