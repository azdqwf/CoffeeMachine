package com.endava.internship.coffee;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.setBalance(50);
        System.out.println(client.makeDrink(DrinkTypes.CAPPUCCINO));
        System.out.println(client.getBalance());

        IngredientsService ingredientsService = new IngredientsService();
        ingredientsService.addIngredient(Ingredients.WATER, 1000);
        ingredientsService.addIngredient(Ingredients.COFFEE, 50);

    }
}
