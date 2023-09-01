package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer damho = new Customer(buyList);

        // 장바구니를 챙긴다.
        damho.bring(mart.provideBasket());

        // 식품을 담는다.
        damho.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        damho.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner s = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.print("\n> ");
        String input_buyList = s.nextLine();
        String[] list = input_buyList.split(" ");
        BuyList buyList = new BuyList();
        for (int i = 0; i < list.length; i = i + 2) {
            buyList.add(list[i], Integer.parseInt(list[i + 1]));
            logger.info("name : {} , amount : {}", list[i], Integer.parseInt(list[i + 1]));
        }
        s.close();
        return buyList;
    }
}
