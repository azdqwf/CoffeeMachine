package com.endava.internship.coffee;


import java.io.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class IngredientsRepository implements Repository {

    private final static File ingredientsFile = new File("C:\\Users\\drihlitchii\\IdeaProjects\\CoffeeMachine\\ingredients.txt");
    private static BufferedOutputStream ingredientsOutput;
    private static BufferedInputStream ingredientsInput;
    private Map<Ingredients, Integer> ingredientsMap = new EnumMap<>(Ingredients.class);
     {
         //Todo BufferedReader
        try {
            ingredientsOutput = new BufferedOutputStream(new FileOutputStream(ingredientsFile));
            ingredientsInput = new BufferedInputStream(new FileInputStream(ingredientsFile));
            String line;
            while ((line = ingredientsInput.read) != null)
            {
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2)
                {
                    String key = parts[0];
                    String value = parts[1];
                    ingredientsMap.put(Ingredients.valueOf(key),  Integer.parseInt(value));
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
            for (Map.Entry entry : map.entrySet()) {
                ingredientsOutput.write(((entry.getKey().toString() + " ").getBytes()));
                ingredientsOutput.write(entry.getValue().toString().getBytes());
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
    public void update(Ingredients item, Integer value) {

    }

    @Override
    public void remove(Ingredients item) {

    }

}
