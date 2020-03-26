package com.recipe.se.recipes.infrastructure.recipe.h2;

import com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Recipe;
import com.recipe.se.recipes.infrastructure.store.h2store.DatabaseStore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "LASTMODIFIED_DATE")
    private Date modifiedDate;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="RECIPE_ID")
    private Set<Ingredient> ingredients;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="RECIPE_STORE", joinColumns={@JoinColumn(referencedColumnName="ID")} , inverseJoinColumns={@JoinColumn(referencedColumnName="ID")})
    private Set<DatabaseStore> databaseStores;

   //this will execute every time before persisting the data. we are checking if created time is null then add today date and this is the case when we add
    //new recipe.

    @PrePersist
    protected void prePersist(){
        if(this.createdDate == null) createdDate = new Date();
    }

    public Set<DatabaseStore> getDatabaseStores() {
        return databaseStores;
    }

    public void setDatabaseStores(Set<DatabaseStore> databaseStores) {
        this.databaseStores = databaseStores;
    }

    public DatabaseRecipe() {
    }

    public DatabaseRecipe(String recipeId, String recipeName, String portion, Set<Ingredient> ingredients
    , Set<DatabaseStore> databaseStores) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.portion = portion;
        this.ingredients = ingredients;
        this.databaseStores = databaseStores;
    }


    public static DatabaseRecipe convertToDatabaseRecipe(Recipe userRecipe, Set<DatabaseStore> databaseStores) {

        return new DatabaseRecipe(UUID.randomUUID().toString(),
                userRecipe.getRecipeName(),
                userRecipe.getPortion(), toDatabaseIngredients(userRecipe.getIngredients()),
                databaseStores);
    }

    public static Set<Ingredient> toDatabaseIngredients(Set<com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Ingredient> ingredients) {
        Set<Ingredient> ingredientSet = new HashSet<>();
        for (com.recipe.se.recipes.infrastructure.recipe.payload.recipe.Ingredient ingredient: ingredients ) {
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
