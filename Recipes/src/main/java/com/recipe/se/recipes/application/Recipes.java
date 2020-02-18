package com.recipe.se.recipes.application;

import java.math.BigDecimal;
import java.util.List;

public class Recipes {
    private List<Recipe> recipes;

    public static class Recipe {
        String recipeId;
        String title;
        int portions;
        List<Ingredient> ingredients;

        public Recipe(String recipeId, String title, int portions, List<Ingredient> ingredients) {
            this.recipeId = recipeId;
            this.title = title;
            this.portions = portions;
            this.ingredients = ingredients;
        }

        @Override
        public String toString() {
            return "Recipe{" +
                    "recipeId='" + recipeId + '\'' +
                    ", title='" + title + '\'' +
                    ", portions=" + portions +
                    ", ingredients=" + ingredients +
                    '}';
        }

        public static class Ingredient {
            Integer id;
            String name;
            BigDecimal amount;
            String unit;

            public Ingredient(Integer id, String name, BigDecimal amount, String unit) {
                this.id = id;
                this.name = name;
                this.amount = amount;
                this.unit = unit;
            }

            @Override
            public String toString() {
                return "Ingredient{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", amount=" + amount +
                        ", unit='" + unit + '\'' +
                        '}';
            }

            public Integer getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public BigDecimal getAmount() {
                return amount;
            }

            public String getUnit() {
                return unit;
            }
        }

        public String getRecipeId() {
            return recipeId;
        }

        public String getTitle() {
            return title;
        }

        public int getPortions() {
            return portions;
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
