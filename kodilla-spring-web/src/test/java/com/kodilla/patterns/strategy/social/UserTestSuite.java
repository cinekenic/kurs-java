package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("Jan Nowak");
        User yGen = new YGeneration("Wojciech Kowalczyk");
        User zGen = new ZGeneration("Leszek Kowalski");

        // When
        String millenialPost = millenial.sharePost();
        String yGenPost = yGen.sharePost();
        String zGenPost = zGen.sharePost();

        // Then
        assertEquals("Facebook", millenialPost);
        assertEquals("Twitter", yGenPost);
        assertEquals("Snapchat", zGenPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User user = new Millenials("Wojciech Kowalczyk");

        //When
        System.out.println("Wojciech Kowalczyk should: ");
        user.sharePost();
        user.setSocialPublisher(new TwitterPublisher());
        System.out.println("Wojciech Kowalczyk now should: ");
        user.sharePost();

        // Then
        assertNotNull(user);
    }
}