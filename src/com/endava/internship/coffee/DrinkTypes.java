package com.endava.internship.coffee;

import java.util.EnumMap;
import java.util.Map;

public enum DrinkTypes {
    AMERICANO(15, setIngredients(0, 5, 0, 300)),
    ESPRESSO(10, setIngredients(0,4,0,150)),
    CAPPUCCINO(18, setIngredients(15,2,50,250)),
    DOUBLE_ESPRESSO(20, setIngredients(0,8,0,300)),
    EMPTY(0, setIngredients(0,0,0,0));

    private Integer price;
    private Map<Ingredients, Integer> recipe;


    public Map<Ingredients, Integer> getRecipe() {
        return recipe;
    }

    static private EnumMap<Ingredients, Integer> setIngredients(Integer choco, Integer coffee, Integer milk, Integer water) {
        EnumMap<Ingredients, Integer> ingredientsMap = new EnumMap<>(Ingredients.class);
        ingredientsMap.putAll(Map.of(Ingredients.CHOCOLATE, choco, Ingredients.COFFEE, coffee,
                Ingredients.MILK, milk, Ingredients.WATER, water));
        return ingredientsMap;
    }

    public Integer getPrice() {
        return price;
    }

    DrinkTypes(Integer price, Map<Ingredients, Integer> recipe) {
        this.price = price;
        this.recipe = recipe;
    }
}
