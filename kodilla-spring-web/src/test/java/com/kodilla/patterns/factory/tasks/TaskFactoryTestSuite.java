package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    public void testShoppingTaskCreation() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.createTask((TaskFactory.SHOPPONG));

        //Then
        assertNotNull(task);
        assertEquals("Grocery Shopping", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    void testPaintingTaskCreation() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.createTask((TaskFactory.PAINTING));

        //Then
        assertNotNull(task);
        assertEquals("Wall Painting", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTaskCreation() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task task = factory.createTask((TaskFactory.DRIVING));

        //Then
        assertNotNull(task);
        assertEquals("Trip", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }
}
