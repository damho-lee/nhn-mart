package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("Customer pickFoods Method Test")
    public void customerPickFoodsMethodTest() {
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("사과", 1000));
        foodStand.add(new Food("수박", 3000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("멜론", 6000));
        String foodName = "오렌지";
        int amount = 2;
        BuyList buyList = new BuyList();
        Basket basket = new Basket();
        buyList.add(foodName, amount);
        Customer customer = new Customer(buyList);
        customer.bring(basket);
        customer.pickFoods(foodStand);
        for (int i = 0; i < amount; i++) {
            Assertions.assertEquals(foodName, basket.getFoods().get(i).getName());
        }
    }

    @Test
    @DisplayName("Customer pickFoods Method Exception Test(상품 매대에 상품 x)")
    public void customerPickFoodsMethodExceptionTest1() {
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("사과", 1000));
        foodStand.add(new Food("수박", 3000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("멜론", 6000));
        BuyList buyList = new BuyList();
        Basket basket = new Basket();
        buyList.add("빼뺴로", 1);
        Customer customer = new Customer(buyList);
        customer.bring(basket);
        String errorMessage = "";
        try {
            customer.pickFoods(foodStand);
        } catch (IllegalArgumentException illegalArgumentException) {
            errorMessage = illegalArgumentException.getMessage();
        }
        Assertions.assertEquals("식품 매대에 없는 상품 구매", errorMessage);
    }

    @Test
    @DisplayName("Customer pickFoods Method Exception Test(상품 재고 부족)")
    public void customerPickFoodsMethodExceptionTest2() {
        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("사과", 1000));
        foodStand.add(new Food("수박", 3000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("오렌지", 4000));
        foodStand.add(new Food("멜론", 6000));
        BuyList buyList = new BuyList();
        Basket basket = new Basket();
        buyList.add("오렌지", 3);
        Customer customer = new Customer(buyList);
        customer.bring(basket);
        String errorMessage = "";
        try {
            customer.pickFoods(foodStand);
        } catch (IllegalArgumentException illegalArgumentException) {
            errorMessage = illegalArgumentException.getMessage();
        }
        Assertions.assertEquals("상품 재고 부족", errorMessage);
    }

    @Test
    @DisplayName("Customer payTox Exception Method Test")
    public void customerPayToxExceptionMethodTEst() {
        NhnMart mart = new NhnMart();
        mart.prepareMart();
        BuyList buyList = new BuyList();
        buyList.add("계란", 5);
        Customer customer = new Customer(buyList);
        customer.bring(mart.provideBasket());
        customer.pickFoods(mart.getFoodStand());
        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.payTox(mart.getCounter()));
    }
}