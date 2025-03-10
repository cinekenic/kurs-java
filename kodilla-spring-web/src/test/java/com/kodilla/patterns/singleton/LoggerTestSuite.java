package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
    //Given
        Logger logger = Logger.INSTANCE;
        logger.log("First log entry");

        //When
        String log = logger.getLastLog();

        //Then
        Assertions.assertEquals("First log entry", log);
    }

    @Test
    public void testSingletonLogger() {
        //Given
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        logger1.log("Second log entry");

        //When
        String lastLogFromLogger2 = logger2.getLastLog();

        //Then
        Assertions.assertEquals("Second log entry", lastLogFromLogger2);
        Assertions.assertSame(logger1, logger2);
    }
}
