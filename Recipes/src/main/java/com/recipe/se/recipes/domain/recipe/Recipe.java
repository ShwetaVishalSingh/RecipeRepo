package com.recipe.se.recipes.domain.recipe;

import com.recipe.se.recipes.infrastructure.recipe.RecipeDetails;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "RECIPE")
public class Recipe implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID")
    private String recipeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PORTION", nullable = false)
    private int portion;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "LASTMODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "INGREDIENTS")
    private String ingredients;

    @Column(name = "STEPS")
    private String steps;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE")
    private String image;

    public static Recipe convertToRecipe(RecipeDetails recipeDetails) {
        return new Recipe(
                recipeDetails.getRecipeName(),
                recipeDetails.getPortion(),
                recipeDetails.getIngredients(),
                recipeDetails.getCookingStep(),
                recipeDetails.getDescription(),
                recipeDetails.getImage(),
                recipeDetails.getType());
    }

    @PrePersist
    protected void prePersist() {
        if (this.createdDate == null) createdDate = new Date();
    }

    public Recipe(String name, int portion, String ingredients, String steps, String description, String image, String type) {
        this.name = name;
        this.portion = portion;
        this.ingredients = ingredients;
        this.steps = steps;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public Recipe() {
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
