package com.endava.internship.coffee;


import java.io.*;
import java.util.EnumMap;
import java.util.Map;

public class IngredientsRepository implements Repository {

    private final File ingredientsFile =
            new File("C:\\Users\\drihlitchii\\IdeaProjects\\CoffeeMachine\\ingredients.txt");
    private BufferedWriter ingredientsOutput;
    private Map<Ingredients, Integer> ingredientsMap = new EnumMap<>(Ingredients.class);

    {
        try {
            BufferedReader ingredientsInput = new BufferedReader(new FileReader(ingredientsFile));
            String line;
            while ((line = ingredientsInput.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];
                    ingredientsMap.put(Ingredients.valueOf(key), Integer.parseInt(value));
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            try {
                ingredientsOutput.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Map<Ingredients, Integer> map) {
        try {
            ingredientsOutput = new BufferedWriter(new FileWriter(ingredientsFile));
            for (Map.Entry entry : map.entrySet()) {
                ingredientsOutput.write(entry.getKey().toString() + " " + entry.getValue().toString() + "\n");
            }
            ingredientsOutput.close();
        } catch (IOException e) {
            try {
                ingredientsOutput.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Map<Ingredients, Integer> recipeMap) {
        for (Map.Entry entry : recipeMap.entrySet()) {
            ingredientsMap.merge((Ingredients) entry.getKey(), (Integer) entry.getValue(), (a, b) -> a - b);
        }
        create(ingredientsMap);
    }

    @Override
    public void remove(Ingredients ingredient) {
        ingredientsMap.put(ingredient, 0);
        create(ingredientsMap);
    }

    public boolean isEnoughIngredients(DrinkTypes drinkType) {
        return ingredientsMap.entrySet().stream().allMatch(ingredientsIntegerEntry -> isEnough(drinkType, ingredientsIntegerEntry));
    }

    private boolean isEnough(DrinkTypes drinkType, Map.Entry<Ingredients, Integer> ingredientsIntegerEntry) {
        return drinkType.getRecipe().get(ingredientsIntegerEntry.getKey()) <= ingredientsIntegerEntry.getValue();
    }


}
