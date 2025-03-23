package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // <--- to ładuje pełną konfigurację aplikacji
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculator() {
        // Given
        double a = 10;
        double b = 5;

        // When & Then
        Assertions.assertEquals(15, calculator.add(a, b));
        Assertions.assertEquals(5, calculator.sub(a, b));
        Assertions.assertEquals(50, calculator.mul(a, b));
        Assertions.assertEquals(2, calculator.div(a, b));
    }
}
