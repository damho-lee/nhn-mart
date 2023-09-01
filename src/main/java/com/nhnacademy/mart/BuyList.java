package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    // TODO add 메서드 생성
    public void add(String name, int amount) {
        items.add(new Item(name, amount));
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
