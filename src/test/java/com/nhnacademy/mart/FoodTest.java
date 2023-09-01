package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoodTest {

    @Test
    @DisplayName("Food Constructor Test(price < 0)")
    public void foodConstructorTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Food("사과", -1));
    }
}
