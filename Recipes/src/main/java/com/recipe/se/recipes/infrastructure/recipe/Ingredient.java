package com.recipe.se.recipes.infrastructure.recipe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {
  private String id;
  private String name;
  private String amount;
  private String unit;

@JsonCreator
    public Ingredient(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("amount") String amount, @JsonProperty("unit") String unit) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", unit='" + unit + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
