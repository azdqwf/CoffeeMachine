package com.endava.internship.coffee;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.setBalance(20);
        System.out.println(client.makeDrink(DrinkTypes.CAPPUCCINO));
        System.out.println(client.getBalance());
        IngredientsService ingredientsService = new IngredientsService();
        ingredientsService.addIngredients(Map.of());


    }
}
