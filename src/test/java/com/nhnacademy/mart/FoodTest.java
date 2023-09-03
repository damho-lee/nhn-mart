package com.nhnacademy.mart;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FoodTest {

    @Test
    @DisplayName("Food Constructor Test(price < 0)")
    void foodConstructorExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Food("사과", -1));
    }

    private static Stream<Arguments> foodSource() {
        return Stream.of(
                Arguments.of("카레", 5000),
                Arguments.of("삼겹살", 8000),
                Arguments.of("귤", 15000),
                Arguments.of("물", 900)
        );
    }

    @ParameterizedTest
    @MethodSource("foodSource")
    @DisplayName("Food Constructor Test")
    void foodConstructorTest(String name, int price) {
        Food food = new Food(name, price);
        Assertions.assertEquals(name, food.getName());
        Assertions.assertEquals(price, food.getPrice());
    }
}
