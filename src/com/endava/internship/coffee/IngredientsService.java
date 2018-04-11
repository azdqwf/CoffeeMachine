package com.endava.internship.coffee;

public class IngredientsService {
    private final IngredientsRepository ingredientsRepository = new IngredientsRepository();
    void addIngredient(Ingredients ingredient, Integer value){
        ingredientsRepository.update(ingredient, value);
    }
    void removeIngredient(Ingredients ingredient){
        ingredientsRepository.remove(ingredient);
    }


}
