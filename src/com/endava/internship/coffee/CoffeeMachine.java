package com.endava.internship.coffee;

/**
 * To create a Coffee-Machine using design patterns
 **/
public class CoffeeMachine {
    private final Repository ingredientsRepository = new IngredientsRepository();

    public DrinkTypes makeDrink(Integer budget, DrinkTypes drinkType) {
        if (budget <= drinkType.getPrice()) {
            throw new IllegalArgumentException("No enough money in your pocket");
        }
        if (ingredientsRepository.isEnoughIngredients(drinkType)) {
            ingredientsRepository.update(drinkType.getRecipe());
            return drinkType;
        }
        return DrinkTypes.EMPTY;
    }
}
