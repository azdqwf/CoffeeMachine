package com.endava.internship.coffee;

import java.util.Map;

public interface Repository {

    void update(Map<Ingredients, Integer> recipeMap);

    void create(Map<Ingredients, Integer> map);

    void remove(Ingredients ingredient);

    boolean isEnoughIngredients(DrinkTypes drinkType);
}