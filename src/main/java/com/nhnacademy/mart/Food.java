package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Food 클래스입니다.
 */
public class Food {
    private static final Logger logger = LoggerFactory.getLogger(Food.class);


    private final String name;
    private final int price;


    public Food(String name, int price) {
        if(price < 0) {
            logger.error("price가 0원보다 작을 수 없습니다.\n상품 준비 실패");
            throw new IllegalArgumentException("price가 0원보다 작을 수 없습니다.");
        }
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
