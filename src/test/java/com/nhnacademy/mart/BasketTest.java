package com.nhnacademy.mart;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketTest {

    private static Stream<Arguments> foodSource() {
        return Stream.of(
                Arguments.of("사과", 1000),
                Arguments.of("오렌지", 2000),
                Arguments.of("배", 3000)
        );
    }
    @ParameterizedTest
    @MethodSource("foodSource")
    @DisplayName("Basket add Method Test")
    void basketAddMethodTest(String name, int price) {
        NhnMart mart = new NhnMart();
        Basket basket = mart.provideBasket();
        List<Food> foods = basket.getFoods();
        foods.add(new Food(name, price));
        Assertions.assertEquals(name, foods.get(0).getName());
        Assertions.assertEquals(price, foods.get(0).getPrice());
    }
}
