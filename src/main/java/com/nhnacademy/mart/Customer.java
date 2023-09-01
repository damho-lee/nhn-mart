package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
        logger.info("buyList 생성");
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
        logger.info("장바구니 들기");
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        for (BuyList.Item item : buyList.getItems()) {
            for (int i = 0; i < item.getAmount(); i++) {
                Food food = foodStand.delete(item.getName());
                basket.add(food);
                logger.info("name : {}, price : {} 상품 장바구니에 넣기 성공.", food.getName(), food.getPrice());
            }
        }
    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        int payment = counter.pay(basket);
        if (payment > 20000) {
            logger.error("돈을 초과하는 상품 구매");
            throw new IllegalArgumentException("돈을 초과하는 상품 구매");
        }
        System.out.println("고객님 결제 후 잔액 : " + (20000 - payment));
        logger.info("고객님 결제 후 잔액 : {}", +(20000 - payment));
    }
}
