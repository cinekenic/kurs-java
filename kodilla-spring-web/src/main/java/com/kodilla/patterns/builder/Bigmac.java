package com.kodilla.patterns.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class PizzaBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public PizzaBuilder withBun(String bun) {
            this.bun = bun;
            return this;
        }

        public PizzaBuilder withBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }
        public PizzaBuilder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder withIngredients(String... ingredients) {
            this.ingredients = Arrays.asList(ingredients);
            return this;
        }

        public Bigmac build() {
            return new Bigmac( bun, burgers, sauce, ingredients);
        }
    }

    public Bigmac( String bun, int burgers, String sauce, List<String> ingredients) {
        this.sauce = sauce;
        this.bun = bun;
        this.burgers = burgers;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
