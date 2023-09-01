package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

/**
 * Basket 클래스입니다.
 */
public class Basket {

    private final ArrayList<Food> foods = new ArrayList<>();

    /**
     * getter입니다.
     */
    public List<Food> getFoods() {
        return foods;
    }

    /**
     * add 메서드입니다.
     *
     * @param food .
     */
    public void add(Food food) {
        foods.add(food);
    }
}
