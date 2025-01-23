package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test is starting...");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test has finished.");
    }

    @Test
    @DisplayName("Test OddNumbersExterminator with an empty list")
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        Assertions.assertTrue(result.isEmpty(), "The result should be an empty list.");
    }

    @Test
    @DisplayName("Test OddNumbersExterminator with a normal list")
    public void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);

        // When
        List<Integer> result = exterminator.exterminate(numbers);

        // Then
        Assertions.assertEquals(expected, result, "The result should contain only even numbers.");
    }
}
