package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTestSuite {

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    private Board prepareTestData() {

        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());

        //Then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        assertEquals(2, longTasks);
    }

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        // Given
        User user1 = new User( "john_doe","John Doe");
        User user2 = new User( "jane_smith", "Jane Smith");

        Task task1 = new Task("Task 1", "Fix UI bug",  user1, user2, LocalDate.now().minusDays(10), LocalDate.now().plusDays(5));
        Task task2 = new Task("Task 2", "Implement login",  user2, user1, LocalDate.now().minusDays(5), LocalDate.now().plusDays(10));
        Task task3 = new Task("Task 3", "Database optimization",  user1, user2, LocalDate.now().minusDays(7), LocalDate.now().plusDays(3));
        Task task4 = new Task("Task 4", "Refactor service layer",  user2, user1, LocalDate.now().minusDays(20), LocalDate.now().plusDays(2));

        TaskList inProgressList = new TaskList("In Progress");
        inProgressList.addTask(task1);
        inProgressList.addTask(task2);
        inProgressList.addTask(task3);

        Board board = new Board("Project Board");
        board.addTaskList(inProgressList);

        //When
        OptionalDouble averageDays = board.getTaskLists().stream()
                .filter(taskList -> "In Progress".equals(taskList.getName()))
                .flatMap(taskList -> taskList.getTasks().stream())
                .mapToLong(task -> ChronoUnit.DAYS.between(task.getCreated(), LocalDate.now()))
                .average();

        //Then
        assertTrue(averageDays.isPresent());
        assertEquals(7.33, averageDays.getAsDouble(), 0.01);

    }
}
