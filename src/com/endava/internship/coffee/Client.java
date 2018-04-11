package com.endava.internship.coffee;

public class Client {
    private final CoffeeMachine coffeeMachine = new CoffeeMachine();
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public DrinkTypes makeDrink(DrinkTypes drink) {
        DrinkTypes tempDrink = coffeeMachine.makeDrink(drink.getPrice(), drink);
        if (balance < drink.getPrice()) {
            return DrinkTypes.EMPTY;
        }
        if (tempDrink == DrinkTypes.EMPTY) {
            return tempDrink;
        }
        balance = balance - drink.getPrice();
        return tempDrink;
    }
}
