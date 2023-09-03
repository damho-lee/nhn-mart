package com.nhnacademy.mart;

import com.nhnacademy.mart.BuyList.Item;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
class BuyListTest {
    private static Stream<Arguments> buyListSource() {
        return Stream.of(
                Arguments.of("사과", 2),
                Arguments.of("오렌지", 5),
                Arguments.of("스윙칩", 1)
        );
    }

    @Test
    @DisplayName("Item Constructor Test (amount < 1)")
    void itemConstructorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("사과", 0));
    }

    @ParameterizedTest
    @MethodSource("buyListSource")
    @DisplayName("BuyList add Method Test")
    void buyListAddMethodTest(String name, int amount) {
        BuyList buyList = new BuyList();
        buyList.add(name, amount);
        Assertions.assertEquals(name, buyList.getItems().get(0).getName());
        Assertions.assertEquals(amount, buyList.getItems().get(0).getAmount());
    }
}
