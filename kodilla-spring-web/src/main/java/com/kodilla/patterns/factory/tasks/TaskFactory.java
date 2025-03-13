package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPONG = "SHOPPONG";
    public static final String PAINTING  = "PAINTING ";
    public static final String DRIVING = "DRIVING";

    public Task createTask(final String taskName) {
        return switch (taskName){
            case SHOPPONG -> new ShoppingTask("Grocery Shopping", "Milk", 2.0);
            case PAINTING  -> new PaintingTask("Wall Painting", "Blue", "Living Room Wall");
            case DRIVING  -> new DrivingTask("Trip", "Mountains", "Car");
            default -> null;
        };
    }
}
