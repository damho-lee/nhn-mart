package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {
    @Test
    @DisplayName("NhnMartTest provideBasket Method(not null) Test")
    public void nhnMartTestProvideBasketNotNullTest() {
        NhnMart mart = new NhnMart();
        Basket basket = mart.provideBasket();
        Assertions.assertFalse(Objects.isNull(basket));
    }

    @Test
    @DisplayName("NhnMart fillFoodStand Method Test")
    public void nhnMartFillFoodStandTest() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        ArrayList<Food> foodsTest = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            foodsTest.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodsTest.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodsTest.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodsTest.add(new Food("사과", 2_000));
        }
        FoodStand foodstand = mart.getFoodStand();
        for (int i = 0; i < foodstand.getFoods().size(); i++) {
            Assertions.assertEquals(foodsTest.get(i).getName(), foodstand.getFoods().get(i).getName());
            Assertions.assertEquals(foodsTest.get(i).getPrice(), foodstand.getFoods().get(i).getPrice());
        }
        Assertions.assertEquals(foodsTest.size(), foodstand.getFoods().size());
    }

    @Test
    @DisplayName("NhnMart getCounter Method Test")
    public void nhnMartGetCounterMethodTest() {
        NhnMart mart = new NhnMart();
        Counter counter = mart.getCounter();
        Assertions.assertFalse(Objects.isNull(counter));
    }
}
