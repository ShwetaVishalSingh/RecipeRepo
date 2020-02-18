package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.infrastructure.recipe.outgoing.DatabaseRecipe;
import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.infrastructure.recipe.incoming.Paylaod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe/")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity getRecipes() {
        List<DatabaseRecipe> recipeList = recipeService.fetchAllRecipies();
        return ResponseEntity.ok(recipeList);
    }

    @PostMapping(value = "addRecipe")
    public ResponseEntity addRecipes(@RequestBody Paylaod paylaod) {
        try {
            recipeService.addRecipes(paylaod);
            return ResponseEntity.ok().body("Recipe has been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("");
    }


    @GetMapping(value = "{recipeId}")
    public ResponseEntity getRecipe(@PathVariable String recipeId) {

        DatabaseRecipe recipe = recipeService.fetchRecipeById(recipeId);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping(value = "{recipeId}")
    public ResponseEntity deleteRecipe(@PathVariable String recipeId) {
        DatabaseRecipe recipe = recipeService.deleteRecipeById(recipeId);
        if (recipe.getRecipeId().equals(recipeId)) {
            return ResponseEntity.ok("Recipe Has been delete");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{Something went wrong while deteleting recipe}");
        }

    }

    @PostMapping(value = "{recipeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRecipe(@PathVariable String recipeId, @RequestBody Paylaod paylaod) {
        DatabaseRecipe recipe = recipeService.updateRecipe(recipeId, paylaod);

        if (recipe.getRecipeId().equals(recipeId)) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{Something went wrong while deteleting recipe}");
        }
    }

}
