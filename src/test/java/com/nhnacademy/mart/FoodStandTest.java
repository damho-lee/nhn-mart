package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {
    @Test
    @DisplayName("FoodStand add Method Test")
    void foodStandAddMethodTest() {
        FoodStand foodstand = new FoodStand();
        String[] names = {"환타", "사이다", "콜라", "쥬스"};
        int[] prices = {1100, 1000, 1300, 1500};
        for (int i = 0; i < names.length; i++) {
            foodstand.add((new Food(names[i], prices[i])));
        }

        for (int i = 0; i < foodstand.getFoods().size(); i++) {
            Assertions.assertEquals(names[i], foodstand.getFoods().get(i).getName());
            Assertions.assertEquals(prices[i], foodstand.getFoods().get(i).getPrice());
        }
    }



    @Test
    @DisplayName("FoodStand delete Method Test")
    void foodStandDeleteMethodTest() {
        FoodStand foodStand = new FoodStand();
        String[] names = {"신라면", "진라면", "삼양라면", "참깨라면"};
        int[] prices = {1100, 1000, 1200, 1500};
        for (int i = 0; i < names.length; i++) {
            foodStand.add(new Food(names[i], prices[i]));
        }
        String food_name = "신라면";
        Food food = foodStand.delete(food_name);
        Assertions.assertEquals(food_name, food.getName());
    }

    @Test
    @DisplayName("Foodstand delete Method Exception Test")
    void foodStandDeleteMethodExceptionTest() {
        FoodStand foodStand = new FoodStand();
        String[] names = {"신라면", "진라면", "삼양라면", "참깨라면"};
        int[] prices = {1100, 1000, 1200, 1500};
        for (int i = 0; i < names.length; i++) {
            foodStand.add(new Food(names[i], prices[i]));
        }
        String food_name = "불닭볶음면";
        Assertions.assertThrows(IllegalArgumentException.class, () -> foodStand.delete(food_name));

    }
}
