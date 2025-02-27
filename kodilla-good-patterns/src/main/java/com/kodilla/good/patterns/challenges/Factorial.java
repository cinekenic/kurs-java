package com.kodilla.good.patterns.challenges;

public class Factorial {
    public static long factorialIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Liczba nie może być ujemna!");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Factorial.factorialIterative(4));
    }
}
