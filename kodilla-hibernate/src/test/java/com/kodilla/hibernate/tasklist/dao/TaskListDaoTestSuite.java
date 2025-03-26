package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.spring.kodillahibernate.KodillaHibernateApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = KodillaHibernateApplication.class)
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("List", "List used for testing");
        taskListDao.save(taskList);

        // When
        List<TaskList> retrievedList = taskListDao.findByListName("List");

        // Then
        assertEquals(1, retrievedList.size());
        assertEquals("List", retrievedList.get(0).getListName());
        assertEquals("List used for testing", retrievedList.get(0).getDescription());

        // Clean up
        taskListDao.delete(taskList);
    }
}