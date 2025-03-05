package com.kodilla.spring.intro.shape;

import java.awt.*;

public class Triangle implements Shape {

    @Override
    public String draw() {
        System.out.println("This is a triangle");
        return "This is a triangle";
    }
}