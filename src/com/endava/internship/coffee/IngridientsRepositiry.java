package com.endava.internship.coffee;


import java.util.HashMap;
import java.util.Map;
public class IngridientsRepositiry implements Repository {

    private final Map<Ingredients, Integer> ingredients = new HashMap<>
            (Map.of(Ingredients.CHOCOLATE, 0,
                    Ingredients.COFFEE, 0,
                    Ingredients.MILK, 0,
                    Ingredients.WATER, 0));

    @Override
    public void update(Ingredients item, Integer value) {
        ingredients.put(item, value);
    }

    @Override
    public void remove(Ingredients item) {

    }
    @Override
    public Map<Ingredients, Integer> get() {
        return ingredients;
    }
}
