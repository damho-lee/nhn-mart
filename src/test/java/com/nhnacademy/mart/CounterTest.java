package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {
    @Test
    @DisplayName("Counter pay Method Test")
    public void counterPayMethodTest() {
        Basket basket = new Basket();
        String[] names = {"스윙칩", "구운감자", "프링글스", "자유시간"};
        int[] prices = {1700, 1000, 2300, 1000};
        for (int i = 0; i < names.length; i++) {
            basket.add(new Food(names[i], prices[i]));
        }
        Counter counter = new Counter();
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        Assertions.assertEquals(sum, counter.pay(basket));
    }
}
