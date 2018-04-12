package com.endava.internship.coffee;

import java.util.Map;

public class IngredientsService {
    private final IngredientsRepository ingredientsRepository = new IngredientsRepository();
    void addIngredients(Map<Ingredients,Integer> newIngredientsMap){
        ingredientsRepository.update(newIngredientsMap);
    }
    void removeIngredient(Ingredients ingredient){
        ingredientsRepository.remove(ingredient);
    }


}
