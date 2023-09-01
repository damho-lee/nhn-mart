package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BuyList 클래스입니다.
 */
public class BuyList {
    private static final Logger logger = LoggerFactory.getLogger(BuyList.class);
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * getter입니다.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * add 메서드입니다.
     *
     * @param name String형입니다.
     *
     *
     * @param amount int형입니다.
     */
    public void add(String name, int amount) {
        items.add(new Item(name, amount));
        logger.info("BuyList에 {} 품목 {}개 추가", name, amount);
    }

    /**
     * Item 클래스입니다.
     */
    public static class Item {
        private final String name;
        private final int amount;

        /**
         * getter입니다.
         */
        public String getName() {
            return name;
        }

        /**
         * getter입니다.
         */
        public int getAmount() {
            return amount;
        }

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

    }
}
