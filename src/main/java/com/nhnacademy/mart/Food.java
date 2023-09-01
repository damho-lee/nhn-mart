package com.nhnacademy.mart;

/**
 * Food 클래스입니다.
 */
public class Food {

    private final String name;
    private final int price;


    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * getter입니다.
     */
    public String getName() {
        return name;
    }

    /**
     * getter입니다.
     */
    public int getPrice() {
        return price;
    }
}
