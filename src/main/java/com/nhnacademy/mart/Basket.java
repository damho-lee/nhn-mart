package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final ArrayList<Food> foods = new ArrayList<>();

    public List<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }
}
