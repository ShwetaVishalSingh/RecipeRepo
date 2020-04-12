package com.recipe.se.recipes;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.application.StoreService;
import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.domain.recipe.H2FileRecipeRepository;
import com.recipe.se.recipes.domain.recipe.RecipeRepository;
import com.recipe.se.recipes.domain.store.StoreH2DatabaseRepository;
import com.recipe.se.recipes.domain.store.StoreRepository;
import com.recipe.se.recipes.domain.user.UserH2DatabaseRepository;
import com.recipe.se.recipes.domain.user.UserRepository;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.user.h2.DatabaseUserRepository;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    private RecipeService recipeService;
    private StoreService storeService;
    private UserService userService;

    public RecipeConfiguration(DatabaseRecipeRepository databaseRepository, DatabaseStoreRepository databaseStoreRepository, DatabaseUserRepository databaseUserRepository) {
        RecipeRepository recipeRepository = new H2FileRecipeRepository(databaseRepository, databaseStoreRepository);
        StoreRepository storeRepository = new StoreH2DatabaseRepository(databaseStoreRepository);
        UserRepository userRepository = new UserH2DatabaseRepository(databaseUserRepository);

        this.recipeService = new RecipeService(recipeRepository);
        this.storeService = new StoreService(storeRepository);
        this.userService = new UserService(userRepository);
    }

    @Bean(name = "recipeService")
    public RecipeService recipeService() {
        return recipeService;
    }

    @Bean(name = "storeService")
    public StoreService storeService() {
        return storeService;
    }

    @Bean(name = "userService")
    public UserService userService() { return userService;};

}
