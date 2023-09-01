package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyList {
    private static final Logger logger = LoggerFactory.getLogger(BuyList.class);
    private final ArrayList<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    // TODO add 메서드 생성
    public void add(String name, int amount) {
        items.add(new Item(name, amount));
        logger.info("BuyList에 {} 품목 {}개 추가", name, amount);

    }

    public static class Item {
        private final String name;
        private final int amount;

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

    }
}
