package com.nhnacademy.mart;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        for (BuyList.Item item : buyList.getItems()) {
            for (int i = 0; i < item.getAmount(); i++) {
                basket.add(foodStand.delete(item.getName()));
            }
        }
    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        int payment = counter.pay(basket);
        if (payment >20000) {
            throw new IllegalArgumentException("돈을 초과하는 상품 구매");
        }
        System.out.println("고객님 결제 후 잔액 : " + (20000-payment));
    }
}
