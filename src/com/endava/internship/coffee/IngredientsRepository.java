package com.endava.internship.coffee;


import java.io.*;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class IngredientsRepository implements Repository {

    private final static File ingredientsFile =
            new File("C:\\Users\\drihlitchii\\IdeaProjects\\CoffeeMachine\\ingredients.txt");
    private static BufferedWriter ingredientsOutput;
    private static BufferedReader ingredientsInput;
    private Map<Ingredients, Integer> ingredientsMap = new EnumMap<>(Ingredients.class);

    {
        try {

            ingredientsInput = new BufferedReader(new FileReader(ingredientsFile));
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

    public void create(Map<Ingredients, Integer> map) {
        try {
            ingredientsOutput = new BufferedWriter(new FileWriter(ingredientsFile));
            for (Map.Entry entry : map.entrySet()) {
                ingredientsOutput.write(entry.getKey().toString() + " ");
                ingredientsOutput.write(entry.getValue().toString()+"\n");
            }
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
    public Map<Ingredients, Integer> getIngredientsAmount() {
        return ingredientsMap;
    }

    @Override
    public void update(Ingredients item, Integer value) {
        ingredientsMap.put(item, value);
        create(ingredientsMap);
    }

    @Override
    public void remove(Ingredients item) {
        ingredientsMap.remove(item);
        create(ingredientsMap);
    }

}
