package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {

        // Given
        World world = new World();

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83000000")));
        europe.addCountry(new Country("France", new BigDecimal("67000000")));

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China", new BigDecimal("1400000000")));
        asia.addCountry(new Country("India", new BigDecimal("1380000000")));
        asia.addCountry(new Country("Japan", new BigDecimal("126000000")));

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Nigeria", new BigDecimal("206000000")));
        africa.addCountry(new Country("Egypt", new BigDecimal("104000000")));
        africa.addCountry(new Country("South Africa", new BigDecimal("59000000")));

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //When
        BigDecimal total = world.getPeopleQuantity();

        //Then
        BigDecimal expected = new BigDecimal("3463000000");
        assertEquals(expected, total);
    }
}
