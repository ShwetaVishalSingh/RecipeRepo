package com.recipe.se.recipes.infrastructure.rest;

import com.recipe.se.recipes.application.RecipeService;
import com.recipe.se.recipes.infrastructure.recipe.RecipeResponse;
import com.recipe.se.recipes.infrastructure.recipe.RecipeDetails;
import com.recipe.se.recipes.infrastructure.recipe.RecipeModel;
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
        List<RecipeModel> recipes;
        try {
            recipes = recipeService.fetchAllRecipes();
        } catch (Exception e) {
            RecipeResponse response = new RecipeResponse(null,"Something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(new RecipeResponse(recipes,"Recipe has been Added"));
    }

    @PostMapping(value = "addRecipe")
    public ResponseEntity<RecipeResponse> addRecipes(@RequestBody RecipeDetails recipeDetails) {
        if (null == recipeDetails) {
            return ResponseEntity.badRequest().body( new RecipeResponse(null,"Payload is empty."));
        }
        try {
            recipeService.addRecipes(recipeDetails);
            return ResponseEntity.ok().body( new RecipeResponse(null,"Recipe has been added."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body( new RecipeResponse(null,"Something went wrong."));
        }
    }


    @GetMapping(value = "{recipeId}")
    public ResponseEntity getRecipe(@PathVariable String recipeId) {

        RecipeModel recipe = null;
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
    public ResponseEntity updateRecipe(@PathVariable String recipeId, @RequestBody RecipeDetails recipeDetails) {
        if (StringUtils.isEmpty(recipeId) || null == recipeDetails) {
            return ResponseEntity.badRequest().body("Recipe id is null or empty");
        }
        try {
            recipeService.updateRecipe(recipeId, recipeDetails);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Recipe is not available so we can not update it");
        }

        return ResponseEntity.ok("Recipe updated Successfully");
    }

    @GetMapping(value = "seller/{sellerId}")
    public ResponseEntity fetchSellerRecipes(@PathVariable String sellerId) {
        List<RecipeModel> recipes = recipeService.fetchBySeller(sellerId);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(value = "search/{searchTerm}")
    public ResponseEntity findRecipeBy(@PathVariable String searchTerm) {
        List<RecipeModel> recipes = recipeService.findRecipeBy(searchTerm);
        return ResponseEntity.ok(recipes);
    }
}
