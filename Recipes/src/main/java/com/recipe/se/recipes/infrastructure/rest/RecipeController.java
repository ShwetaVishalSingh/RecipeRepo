package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Paylaod;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/recipe/")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity getRecipes() {
        List<Recipe> recipeList;
        try {
            recipeList = recipeService.fetchAllRecipies();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while fetching the recipe");
        }
        return ResponseEntity.ok(recipeList);
    }

    @PostMapping(value = "addRecipe")
    public ResponseEntity addRecipes(@RequestBody Paylaod paylaod) {
        if (null == paylaod) {
            return ResponseEntity.badRequest().body(" payload is empty");
        }
        try {
            recipeService.addRecipes(paylaod);
            return ResponseEntity.ok().body("Recipe has been added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong" + e);
        }
    }


    @GetMapping(value = "{recipeId}")
    public ResponseEntity getRecipe(@PathVariable String recipeId) {

        Recipe recipe = null;
        try {
            recipe = recipeService.fetchRecipeById(recipeId);
        } catch (Exception e) {
            ResponseEntity.ok().body("Given recipe is not available in database");
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping(value = "{recipeId}")
    public ResponseEntity deleteRecipe(@PathVariable String recipeId) {
        if (StringUtils.isEmpty(recipeId)) {
            return ResponseEntity.badRequest().body("recipeId is empty");
        }
        recipeService.deleteRecipeById(recipeId);
        return ResponseEntity.ok("Recipe Has been delete");

    }

    @PostMapping(value = "{recipeId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRecipe(@PathVariable String recipeId, @RequestBody Paylaod paylaod) {
        if (StringUtils.isEmpty(recipeId) || null == paylaod) {
            return ResponseEntity.badRequest().body("Recipe id is null or empty");
        }
        try {
            recipeService.updateRecipe(recipeId, paylaod);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Recipe is not available so we can not update it");
        }

        return ResponseEntity.ok("Recipe Udated Successfully");
    }

    @GetMapping(value = "store/{storeId}")
    public ResponseEntity fetchStoreRecipes(@PathVariable String storeId) {
        List<Recipe> recipes = recipeService.fetchByStore(storeId);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(value = "search/{searchTerm}")
    public ResponseEntity findRecipeBy(@PathVariable String searchTerm) {
        List<Recipe> recipes = recipeService.findRecipeBy(searchTerm);
        return ResponseEntity.ok(recipes);
    }
}
