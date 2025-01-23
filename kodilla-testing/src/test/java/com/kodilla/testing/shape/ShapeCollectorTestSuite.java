package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import java.util.List;

@DisplayName("Shape Collector Test Suite")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for Adding and Removing Shapes")
    class AddRemoveTests {

        @Test
        @DisplayName("Test adding a shape")
        void testAddFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(5.0);

            // When
            shapeCollector.addFigure(circle);

            // Then
            List<Shape> shapes = shapeCollector.showFigures();
            Assertions.assertEquals(1, shapes.size());
            Assertions.assertEquals("Circle", shapes.get(0).getShapeName());
        }

        @Test
        @DisplayName("Test removing a shape")
        void testRemoveFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(4.0);
            shapeCollector.addFigure(square);

            // When
            boolean result = shapeCollector.removeFigure(square);

            // Then
            List<Shape> shapes = shapeCollector.showFigures();
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapes.size());
        }
    }

    @Nested
    @DisplayName("Tests for Retrieving Shapes")
    class RetrieveTests {

        @Test
        @DisplayName("Test getting a shape by index")
        void testGetFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(3.0, 4.0);
            shapeCollector.addFigure(triangle);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            Assertions.assertNotNull(retrievedShape);
            Assertions.assertEquals("Triangle", retrievedShape.getShapeName());
        }

        @Test
        @DisplayName("Test getting a shape by invalid index")
        void testGetFigureInvalidIndex() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            Shape retrievedShape = shapeCollector.getFigure(1);

            // Then
            Assertions.assertNull(retrievedShape);
        }
    }

    @Nested
    @DisplayName("Tests for Showing Shapes")
    class ShowTests {

        @Test
        @DisplayName("Test showing all shapes")
        void testShowFigures() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(5.0);
            Shape square = new Square(4.0);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);

            // When
            List<Shape> shapes = shapeCollector.showFigures();

            // Then
            Assertions.assertEquals(2, shapes.size());
            Assertions.assertEquals("Circle", shapes.get(0).getShapeName());
            Assertions.assertEquals("Square", shapes.get(1).getShapeName());
        }
    }
}
