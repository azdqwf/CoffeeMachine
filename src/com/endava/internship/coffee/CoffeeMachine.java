package com.endava.internship.coffee;
/**
 *
 * To create a Coffee-Machine using design patterns
 *
 * **/
public class CoffeeMachine {
    public static Coffee makeCappuccino(){
        return new Coffee.Builder(2, 300).addChocolate(15).addfMilk(75).build();
    }
    public static Coffee makeAmericano(){
        return new Coffee.Builder(4, 100).build();
    }
    public static Coffee makeEspresso(){
        return new Coffee.Builder(4, 300).build();
    }

}
