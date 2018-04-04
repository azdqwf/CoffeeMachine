package com.endava.internship.coffee;

import java.util.List;
import java.util.Map;

public interface Repository {

    void update(Ingredients item, Integer value);

    void remove(Ingredients item);


}