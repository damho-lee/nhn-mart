package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Basket basket) {
        int sum = 0;
        for (Food food : basket.getFoods()) {
            sum += food.getPrice();
            logger.info("{}원짜리 {} 바코드 찍음", food.getPrice(), food.getName());
        }
        System.out.println("총 가격은 " + sum + "원 입니다.");
        logger.info("총 가격은 {}원 입니다.", sum);

        return sum;
    }
}
