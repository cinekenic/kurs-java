package com.kodilla.testing;

public class TestingMain {

    public static String findVowels(String inputString) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        for (char ch : inputString.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        String input = "Adam";
        String vowelsOnly = findVowels(input);
        System.out.println(vowelsOnly);
    }
}