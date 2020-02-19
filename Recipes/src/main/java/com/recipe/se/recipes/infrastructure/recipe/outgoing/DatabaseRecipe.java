package com.recipe.se.recipes.infrastructure.recipe.outgoing;

import com.recipe.se.recipes.infrastructure.recipe.incoming.Recipe;
import org.apache.tomcat.util.buf.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "RECIPE")
public class DatabaseRecipe {
    @Id
    @Column(name = "RECIPE_ID")
    private String recipeId;

    @Column(name = "RECIPE_NAME")
    private String recipeName;

    @Column(name = "PROTION")
    private String portion;

    @Column(name = "ingredients")
    private String ingredients;


    public DatabaseRecipe() {
    }

    public DatabaseRecipe(String recipeId, String recipeName, String portion, String ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
    }


    public static DatabaseRecipe of(Recipe userRecipe) {
        return new DatabaseRecipe(userRecipe.getRecipeId(),
                userRecipe.getRecipeName(),
                userRecipe.getPortion(), StringUtils.join(userRecipe.getIngredients(), '-'));
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseRecipe)) return false;
        DatabaseRecipe that = (DatabaseRecipe) o;
        return Objects.equals(getRecipeId(), that.getRecipeId()) &&
                Objects.equals(getRecipeName(), that.getRecipeName()) &&
                Objects.equals(getPortion(), that.getPortion()) &&
                Objects.equals(getIngredients(), that.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getRecipeName(), getPortion(), getIngredients());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId='" + recipeId + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", portion='" + portion + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
