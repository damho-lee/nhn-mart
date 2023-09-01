package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodStand {
    private static final Logger logger = LoggerFactory.getLogger(FoodStand.class);
    private final ArrayList<Food> foods = new ArrayList<>();

    public List<Food> getFoods() {
        return foods;
    }

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구현
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
