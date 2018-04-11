package com.endava.internship.coffee;


import java.io.*;
import java.util.EnumMap;
import java.util.Map;

public class IngredientsRepository implements Repository {

    private final  File ingredientsFile =
            new File("C:\\Users\\drihlitchii\\IdeaProjects\\CoffeeMachine\\ingredients.txt");
    private  BufferedWriter ingredientsOutput;
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
    public Map<Ingredients, Integer> getIngredientsAmount() {
        return ingredientsMap;
    }

    @Override
    public void update(Ingredients item, Integer value) {
        ingredientsMap.put(item, ingredientsMap.get(item) + value);
        create(ingredientsMap);
    }

    @Override
    public void remove(Ingredients ingredient) {
        ingredientsMap.put(ingredient, 0);
        create(ingredientsMap);
    }
}
