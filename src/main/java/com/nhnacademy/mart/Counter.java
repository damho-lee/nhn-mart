package com.nhnacademy.mart;

public class Counter {
    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Basket basket) {
        int sum = 0;
        for (Food food : basket.getFoods()) {
            sum += food.getPrice();
        }
        System.out.println("총 가격은 " + sum + "원 입니다.");
        return sum;
    }
}
