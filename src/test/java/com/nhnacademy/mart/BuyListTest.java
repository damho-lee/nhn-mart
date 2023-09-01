package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyListTest {
    @Test
    @DisplayName("Item Constructor Test (amount < 0)")
    public void itemConstructorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BuyList.Item("사과", 0));
    }
}
