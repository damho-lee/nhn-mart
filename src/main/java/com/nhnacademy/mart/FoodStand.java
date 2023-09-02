package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FoodStand 클래스입니다.
 */
public class FoodStand {
    private static final Logger logger = LoggerFactory.getLogger(FoodStand.class);
    private final ArrayList<Food> foods = new ArrayList<>();

    public List<Food> getFoods() {
        return foods;
    }

    /**
     * add 메서드입니다.
     * foodStand(진열대)에 상품 추가.
     *
     * @param food .
     */
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * delete 메서드입니다.
     *
     * @param name .
     *
     * @return Food .
     */
    public Food delete(String name) {
        Food returnFood = null;
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                returnFood = food;
                foods.remove(food);
                break;
            }
        }
        if (returnFood == null) {
            logger.error("식품 매대에 없는 상품 구매");
            throw new IllegalArgumentException("식품 매대에 없는 상품 구매");
        }
        return returnFood;
    }
}
