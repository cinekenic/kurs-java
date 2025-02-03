package com.kodilla.stream.iterate;

import java.util.stream.Stream;

public class NumbersGenerator {

    public static void generateEven(int max) {
        Stream.iterate(1, n -> n + 1).limit(max).filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
    }
}
