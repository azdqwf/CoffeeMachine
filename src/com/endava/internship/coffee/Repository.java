package com.endava.internship.coffee;

import java.util.List;
        import java.util.Map;

public interface Repository {
    Map<Ingredients, Integer> getIngredientsAmount();

    void update(Ingredients item, Integer value);

    void create(Map<Ingredients, Integer> map);

    void remove(Ingredients ingredient);
}