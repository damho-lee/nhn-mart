package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NhnMart 클래스입니다.
 */
public class NhnMart {

    private static final Logger logger = LoggerFactory.getLogger(NhnMart.class);

    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    /**
     * fillFoodStand() 메서드 입니다.
     * 진열대에 상품(food) 놓기.
     */
    private void fillFoodStand() {
        logger.info("상품 준비");
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
        logger.info("상품 준비 완료");
    }

    /**
     * provideBasket() 메서드입니다.
     *
     * @return Basket() .
     */
    public Basket provideBasket() {
        return new Basket();
    }

    /**
     * getter() 메서드 입니다.
     */
    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    /**
     * getCounter() 메서드입니다.
     *
     * @return Counter .
     */
    public Counter getCounter() {
        return new Counter();
    }
}
