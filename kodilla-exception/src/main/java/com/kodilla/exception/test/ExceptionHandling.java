package com.kodilla.exception.test;

public class ExceptionHandling {
    public void handleException(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String res = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println("Result: " + res);
        }catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Finally block values x=" + x + ", y=" + y);
        }
    }
}
