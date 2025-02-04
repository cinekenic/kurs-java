package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstChallengeTestSuite {
    @Test
    void testValidInput() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertDoesNotThrow(()->{
            assertEquals("Done!", secondChallenge.probablyIWillThrowException(1.5, 2.0));
        });
    }

    @Test
    void testInvalidXLessThanOne() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(0.9, 2.0));
    }

    @Test
    void testInvalidXGreaterThanOrEqualTwo() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(2.0, 2.0));
    }

    @Test
    void testInvalidYEqualsOnePointFive() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(1.5, 1.5));
    }

    @Test
    void testInvalidXAndY() {
        SecondChallenge secondChallenge = new SecondChallenge();
        assertThrows(Exception.class, ()-> secondChallenge.probablyIWillThrowException(2.1, 1.5));
    }
}
