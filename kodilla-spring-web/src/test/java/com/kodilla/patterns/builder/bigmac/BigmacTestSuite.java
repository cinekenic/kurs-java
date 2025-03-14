package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.Bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.PizzaBuilder().withBun("z sezamem").withBurgers(2).withSauce("standard").withIngredients("sałata", "cebula", "ogórek", "papryczki chilli", "ser").build();

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        int ingredients = bigmac.getIngredients().size();

        //Then
        assertEquals(5, howManyIngredients);
        assertEquals("z sezamem", bun);
        assertEquals(2, burgers);
        assertEquals("standard", sauce);
        assertTrue(bigmac.getIngredients().contains("sałata"));
        assertTrue(bigmac.getIngredients().contains("cebula"));
        assertTrue(bigmac.getIngredients().contains("ogórek"));
        assertTrue(bigmac.getIngredients().contains("papryczki chilli"));
        assertTrue(bigmac.getIngredients().contains("ser"));

    }
}
