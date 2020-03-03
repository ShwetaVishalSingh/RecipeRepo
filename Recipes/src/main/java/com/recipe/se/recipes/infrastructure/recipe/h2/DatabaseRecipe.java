package com.recipe.se.recipes.infrastructure.recipe.h2;

import com.recipe.se.recipes.infrastructure.recipe.payload.Recipe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "RECIPE")
public class DatabaseRecipe implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "ID")
    private String recipeId;

    @Column(name = "RECIPE_NAME")
    private String recipeName;

    @Column(name = "PROTIONS", nullable = false)
    private String portion;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="RECIPE_ID")
    private Set<Ingredient> ingredients;


    public DatabaseRecipe() {
    }

    public DatabaseRecipe(String recipeId, String recipeName, String portion, Set<Ingredient> ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
    }


    public static DatabaseRecipe convertToDatabaseRecipe(Recipe userRecipe) {
        return new DatabaseRecipe(UUID.randomUUID().toString(),
                userRecipe.getRecipeName(),
                userRecipe.getPortion(), toDatabaseIngredients(userRecipe.getIngredients()));
    }

    public static Set<Ingredient> toDatabaseIngredients(Set<com.recipe.se.recipes.infrastructure.recipe.payload.Ingredient> ingredients) {
        Set<Ingredient> ingredientSet = new HashSet<>();
        for (com.recipe.se.recipes.infrastructure.recipe.payload.Ingredient ingredient: ingredients ) {
         ingredientSet.add(new Ingredient(UUID.randomUUID().toString(),ingredient.getName(),ingredient.getAmount(),ingredient.getUnit()));
        }
        return ingredientSet;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


}
