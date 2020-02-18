package com.recipe.se.recipes;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.domian.InMemoryDatabaseRepository;
import com.recipe.se.recipes.domian.RecipeRepository;
import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public class RecipeConfiguration {

    private RecipeService recipeService;


    public RecipeConfiguration(CrudRepository databaseRepository) {
        RecipeRepository inMemoryDataBaseRepository = new InMemoryDatabaseRepository(databaseRepository);

        this.recipeService = new RecipeService(inMemoryDataBaseRepository);
    }

    @Bean(name = "recipeService")
    public RecipeService recipeService() {
        return recipeService;
    }

}
