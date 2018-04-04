package com.endava.internship.coffee;

class Drink {
    private final int millsOfWater;
    private final int gramsOfCoffee;
    private final int gramsOfChocolate;
    private final int millsOfMilk;

    public static class Builder {
        private int millsOfWater;
        private final int gramsOfCoffee;
        private int gramsOfChocolate = 0;
        private int millsOfMilk = 0;


        Builder(int gramsOfCoffee, int millsOfWater) {
            this.gramsOfCoffee = gramsOfCoffee;
            this.millsOfWater = millsOfWater;
        }

        public Builder addChocolate(int val) {
            gramsOfChocolate = val;
            return this;
        }

        public Builder addfMilk(int val) {
            millsOfMilk = val;
            return this;
        }

        public Drink build() {
            return new Drink(this);
        }
    }

    private Drink(Builder builder) {
        millsOfWater = builder.millsOfWater;
        gramsOfCoffee = builder.gramsOfCoffee;
        gramsOfChocolate = builder.gramsOfChocolate;
        millsOfMilk = builder.millsOfMilk;
    }

    @Override
    public String toString() {
        return ("I consist: " +
                millsOfWater + " mills of water, " +
                gramsOfCoffee + " grams of coffee, " +
                gramsOfChocolate + " grams of chocolate, " +
                millsOfMilk + " mills of milk.");
    }
}
