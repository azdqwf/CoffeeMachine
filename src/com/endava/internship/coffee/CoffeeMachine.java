package com.endava.internship.coffee;

import java.util.*;
import java.util.stream.Stream;

/**
 * To create a Coffee-Machine using design patterns
 **/
public class CoffeeMachine {
    Repository ingredientsRepository = new IngredientsRepository();

    public DrinkTypes makeDrink(Integer price, DrinkTypes drinkType) {
        boolean ok = true;
        if (price >= drinkType.getPrice()) {
            Map<Ingredients, Integer> ingredientsAmount = ingredientsRepository.getIngredientsAmount();
            Map<Ingredients, Integer> recipe = drinkType.getRecipe();
      //      EnumMap<Ingredients, Integer> = new EnumMap<>(Map.of()recipe);
            System.out.println(recipe.getClass());
            System.out.println(ingredientsAmount.getClass());
            Iterator<Map.Entry<Ingredients, Integer>> ingredientsAmountIterator = ingredientsAmount.entrySet().iterator();
            Iterator<Map.Entry<Ingredients, Integer>> recipeIterator = recipe.entrySet().iterator();
            while (ingredientsAmountIterator.hasNext() && recipeIterator.hasNext()) {
                if (ingredientsAmountIterator.next().getValue() < recipeIterator.next().getValue()) {

                }
            }
            if (ok) {
                ingredientsAmountIterator = ingredientsAmount.entrySet().iterator();
                recipeIterator = recipe.entrySet().iterator();
                while (ingredientsAmountIterator.hasNext() && recipeIterator.hasNext()) {
                    //System.out.println(ingredientsAmountIterator.next() +" "+ recipeIterator.next());
//                    ingredientsRepository.update(ingredientsAmountIterator.next().getKey(),
//                            ingredientsAmountIterator.next().getValue() - recipeIterator.next().getValue());

                }
            }


        }
        if (ok) return drinkType;
        return DrinkTypes.EMPTY;
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        for (int i = 0; i < 2; i++) {
            System.out.println(cm.makeDrink(20, DrinkTypes.AMERICANO));
        }

    }
}