package com.recipe.se.recipes.infrastructure.recipe.h2;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "ForeignKeyAssoIngredientEntity")
@Table(name = "INGREDIENTS")

public class Ingredient implements Serializable {
    private static final long serialVersionUID = -6790693372846798580L;
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "amount")
    private String amount;

    @Column(name = "unit")
    private String unit;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient(String id, String name, String amount, String unit) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
