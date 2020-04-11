package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.infrastructure.recipe.RecipeResponse;
import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Payload;
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
    public ResponseEntity <RecipeResponse>getRecipes() {
        List<Recipe> recipeList;
        try {
            recipeList = recipeService.fetchAllRecipies();
        } catch (Exception e) {
            RecipeResponse response = new RecipeResponse(null,"Something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(new RecipeResponse(recipeList,""));
    }

    @PostMapping(value = "addRecipe")
    public ResponseEntity<RecipeResponse> addRecipes(@RequestBody Payload payload) {
        if (null == payload) {
            return ResponseEntity.badRequest().body( new RecipeResponse(null,"Payload is empty"));
        }
        try {
            recipeService.addRecipes(payload);
            return ResponseEntity.ok().body( new RecipeResponse(null,"Recipe has been added"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body( new RecipeResponse(null,"Something went wrong "));
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
    public ResponseEntity updateRecipe(@PathVariable String recipeId, @RequestBody Payload paylaod) {
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
