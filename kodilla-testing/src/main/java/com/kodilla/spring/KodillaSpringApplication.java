package com.kodilla.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kodilla.spring", "com.kodilla.testing"})
public class KodillaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(KodillaSpringApplication.class, args);
    }
}
