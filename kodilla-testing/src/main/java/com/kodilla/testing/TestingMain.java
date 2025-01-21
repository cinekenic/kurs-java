package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {



    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        SimpleUser anotherUser = new SimpleUser("anotherUser");
        String anotherResult = anotherUser.getUsername();

        if (anotherResult.equals("anotherUser")) {
            System.out.println("test OK - drugi użytkownik");
        } else {
            System.out.println("Error - drugi użytkownik!");
        }

        System.out.println("Test - metoda add:");

        //metoda add
        Calculator.MathOperations calculator = new Calculator().new MathOperations();
        int addResult = calculator.add(5, 3);
        if (addResult == 8) {
            System.out.println("test OK - metoda add");
        } else {
            System.out.println("Error - metoda add! Oczekiwano 8, a otrzymano " + addResult);
        }

        System.out.println("\nTest - metoda subtract:");

        //metoda subtract
        int subtractResult = calculator.subtract(10, 4);
        if (subtractResult == 6) {
            System.out.println("test OK - metoda subtract");
        } else {
            System.out.println("Error - metoda subtract! Oczekiwano 6, a otrzymano " + subtractResult);
        }

    }
}
