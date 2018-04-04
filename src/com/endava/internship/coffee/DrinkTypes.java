package com.endava.internship.coffee;

import java.util.Map;

public enum DrinkTypes {
    AMERICANO(10, Map.of(Ingredients.COFFEE, 4, Ingredients.WATER, 300)),
    ESPRESSO(10, Map.of(Ingredients.COFFEE, 4, Ingredients.WATER, 150)),
    CAPPUCCINO(15, Map.of(Ingredients.COFFEE, 2, Ingredients.CHOCOLATE, 10, Ingredients.MILK, 50)),
    DOUBLE_ESPRESSO(20, Map.of(Ingredients.COFFEE, 8, Ingredients.WATER, 300));

    private Integer price;
    private Map<Ingredients, Integer> recipe;

    private DrinkTypes(Integer price, Map<Ingredients, Integer> recipe) {
        this.price = price;
        this.recipe = recipe;
    }
}
