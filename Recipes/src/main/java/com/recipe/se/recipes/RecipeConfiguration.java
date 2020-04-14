package com.recipe.se.recipes;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.application.SellerService;
import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.domain.recipe.H2FileRecipeRepository;
import com.recipe.se.recipes.domain.recipe.RecipeRepository;
import com.recipe.se.recipes.domain.store.SellerH2DatabaseRepository;
import com.recipe.se.recipes.domain.store.SellerRepository;
import com.recipe.se.recipes.domain.user.UserH2DatabaseRepository;
import com.recipe.se.recipes.domain.user.UserRepository;
import com.recipe.se.recipes.infrastructure.recipe.h2.DatabaseRecipeRepository;
import com.recipe.se.recipes.infrastructure.user.h2.DatabaseUserRepository;
import com.recipe.se.recipes.infrastructure.seller.h2store.DatabaseSellerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    private RecipeService recipeService;
    private SellerService storeService;
    private UserService userService;

    public RecipeConfiguration(DatabaseRecipeRepository databaseRepository, DatabaseSellerRepository databaseStoreRepository, DatabaseUserRepository databaseUserRepository) {
        RecipeRepository recipeRepository = new H2FileRecipeRepository(databaseRepository, databaseStoreRepository);
        SellerRepository storeRepository = new SellerH2DatabaseRepository(databaseStoreRepository);
        UserRepository userRepository = new UserH2DatabaseRepository(databaseUserRepository);

        this.recipeService = new RecipeService(recipeRepository);
        this.storeService = new SellerService(storeRepository);
        this.userService = new UserService(userRepository);
    }

    @Bean(name = "recipeService")
    public RecipeService recipeService() {
        return recipeService;
    }

    @Bean(name = "storeService")
    public SellerService storeService() {
        return storeService;
    }

    @Bean(name = "userService")
    public UserService userService() { return userService;};

}
