package com.recipe.se.recipes;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.application.StoreService;
import com.recipe.se.recipes.domain.InMemoryDatabaseRepository;
import com.recipe.se.recipes.domain.RecipeRepository;
import com.recipe.se.recipes.domain.store.StoreH2DatabaseRepository;
import com.recipe.se.recipes.domain.store.StoreRepository;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    private RecipeService recipeService;
    private StoreService storeService;

    public RecipeConfiguration(DatabaseRecipeRepository databaseRepository, DatabaseStoreRepository databaseStoreRepository) {
        RecipeRepository recipeRepository = new InMemoryDatabaseRepository(databaseRepository, databaseStoreRepository);
        StoreRepository storeRepository = new StoreH2DatabaseRepository(databaseStoreRepository);

        this.recipeService = new RecipeService(recipeRepository);
        this.storeService = new StoreService(storeRepository);
    }

    @Bean(name = "recipeService")
    public RecipeService recipeService() {
        return recipeService;
    }

    @Bean(name = "storeService")
    public StoreService storeService() {
        return storeService;
    }
}
