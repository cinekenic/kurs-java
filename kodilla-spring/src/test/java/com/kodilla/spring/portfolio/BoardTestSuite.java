package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean(Board.class);

        //When
        board.getToDoList().addTask("Zadanie do zrobienia");
        board.getInProgressList().addTask("Zadanie w toku");
        board.getDoneList().addTask("Zadanie ukończone");

        //Then
        assertEquals("Zadanie do zrobienia", board.getToDoList().getTasks().get(0));
        assertEquals("Zadanie w toku", board.getInProgressList().getTasks().get(0));
        assertEquals("Zadanie ukończone", board.getDoneList().getTasks().get(0));
    }
}
