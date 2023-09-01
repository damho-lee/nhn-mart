package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NhnMartShell 클래스입니다.
 * main method 포함.
 */

public class NhnMartShell {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    /**
     * main 메서드입니다.
     */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

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

    /**
     * inputBuyListFromShell 메서드입니다.
     *
     * @return buyList
     */
    private static BuyList inputBuyListFromShell() {
        Scanner s = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.print("\n> ");
        String inputBuyList = s.nextLine();
        String[] list = inputBuyList.split(" ");
        BuyList buyList = new BuyList();
        for (int i = 0; i < list.length; i = i + 2) {
            try {
                buyList.add(list[i], Integer.parseInt(list[i + 1]));
            } catch (NumberFormatException numberFormatException) {
                logger.error("NumberFormatException");
                throw new NumberFormatException("사고자 하는 품목 입력 서식 확인해주세요.");
            }
        }
        s.close();
        return buyList;
    }
}
