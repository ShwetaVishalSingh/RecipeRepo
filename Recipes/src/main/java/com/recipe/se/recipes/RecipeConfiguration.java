package com.recipe.se.recipes;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.application.SellerService;
import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.domain.repository.CrudRecipeRepository;
import com.recipe.se.recipes.domain.repository.CrudSellerRepository;
import com.recipe.se.recipes.domain.repository.RecipeDbRepository;
import com.recipe.se.recipes.domain.repository.RecipeRepository;
import com.recipe.se.recipes.domain.repository.SellerDbRepository;
import com.recipe.se.recipes.domain.repository.SellerRepository;
import com.recipe.se.recipes.domain.repository.UserDbRepository;
import com.recipe.se.recipes.domain.repository.UserRepository;
import com.recipe.se.recipes.domain.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    private RecipeService recipeService;
    private SellerService storeService;
    private UserService userService;

    public RecipeConfiguration(CrudRecipeRepository crudRecipeRepo, CrudSellerRepository crudSellerRepo, CrudUserRepository crudUserRepo) {
        RecipeRepository recipeRepository = new RecipeDbRepository(crudRecipeRepo);
        SellerRepository storeRepository = new SellerDbRepository(crudSellerRepo);
        UserRepository userRepository = new UserDbRepository(crudUserRepo);

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
