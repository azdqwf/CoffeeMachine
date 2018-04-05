package com.endava.internship.coffee;

import java.util.EnumMap;
import java.util.Map;

public enum DrinkTypes {
    AMERICANO(15, Map.of(Ingredients.CHOCOLATE, 0, Ingredients.COFFEE,
            5, Ingredients.MILK, 0, Ingredients.WATER, 300)),
    ESPRESSO(10, Map.of(Ingredients.CHOCOLATE, 0, Ingredients.COFFEE,
            4, Ingredients.MILK, 0, Ingredients.WATER, 150)),
    CAPPUCCINO(18, Map.of(Ingredients.CHOCOLATE, 15, Ingredients.COFFEE,
            2, Ingredients.MILK, 50, Ingredients.WATER, 250)),
    DOUBLE_ESPRESSO(20, Map.of(Ingredients.CHOCOLATE, 0, Ingredients.COFFEE,
            8, Ingredients.MILK, 0, Ingredients.WATER, 300)),
    EMPTY(0, Map.of(Ingredients.CHOCOLATE, 0, Ingredients.COFFEE,
            0, Ingredients.MILK, 0, Ingredients.WATER, 0));

    private Integer price;
    private Map<Ingredients, Integer> recipe;

    public Map<Ingredients, Integer> getRecipe() {
        return recipe;
    }

    public Integer getPrice() {
        return price;
    }

    DrinkTypes(Integer price, Map<Ingredients, Integer> recipe) {
        this.price = price;
        this.recipe = recipe;
    }
}
