package com.endava.internship.coffee;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * To create a Coffee-Machine using design patterns
 **/
public class CoffeeMachine {
    private final Repository ingredientsRepository = new IngredientsRepository();

    public DrinkTypes makeDrink(Integer price, DrinkTypes drinkType) {
        boolean ok = true;
        if (price >= drinkType.getPrice()) {
            Map<Ingredients, Integer> ingredientsAmount = ingredientsRepository.getIngredientsAmount();
            Map<Ingredients, Integer> recipe = drinkType.getRecipe();
            Iterator<Map.Entry<Ingredients, Integer>> ingredientsAmountIterator = ingredientsAmount.entrySet().iterator();
            Iterator<Map.Entry<Ingredients, Integer>> recipeIterator = recipe.entrySet().iterator();
//
//            ingredientsAmount.entrySet().stream().filter(ingredientsIntegerEntry -> {
//                Integer integer = recipe.get(ingredientsIntegerEntry.getKey());
//                if (integer < ingredientsIntegerEntry.getValue()) {
//
//                }
//
//            });
            while (ingredientsAmountIterator.hasNext() && recipeIterator.hasNext()) {
                if (ingredientsAmountIterator.next().getValue() < recipeIterator.next().getValue()) {
                    ok = false;
                }
            }
            if (ok) {
                ingredientsAmountIterator = ingredientsAmount.entrySet().iterator();
                recipeIterator = recipe.entrySet().iterator();

                while (ingredientsAmountIterator.hasNext() && recipeIterator.hasNext()) {
                    ingredientsRepository.update(ingredientsAmountIterator.next().getKey(), -recipeIterator.next().getValue());
                }
            }
        }
        if (ok) return drinkType;
        return DrinkTypes.EMPTY;
    }
}