package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTest {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
    statisticsMock = mock(Statistics.class);
    forumStatistics = new ForumStatistics();
    }

@Test
    void testZeroPosts() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
    when(statisticsMock.postsCount()).thenReturn(0);
    when(statisticsMock.commentsCount()).thenReturn(0);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertEquals(0, forumStatistics.getPostCount());
    assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
    assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
}

@Test
void testThousandPosts() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
    when(statisticsMock.postsCount()).thenReturn(1000);
    when(statisticsMock.commentsCount()).thenReturn(500);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertEquals(1000, forumStatistics.getPostCount());
    assertEquals(100.0, forumStatistics.getAvgPostsPerUser());
    assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
}

@Test
void testZeroComments() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
    when(statisticsMock.postsCount()).thenReturn(100);
    when(statisticsMock.commentsCount()).thenReturn(0);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertEquals(0, forumStatistics.getCommentCount());
    assertEquals(0.0, forumStatistics.getAvgCommentsPerUser());
    assertEquals(0.0, forumStatistics.getAvgCommentsPerPost());
}

@Test
void testCommentsLessThanPosts() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
    when(statisticsMock.postsCount()).thenReturn(100);
    when(statisticsMock.commentsCount()).thenReturn(50);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertTrue(forumStatistics.getCommentCount() < forumStatistics.getPostCount());
    assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
}

@Test
void testCommentsGreaterThanPosts() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(10));
    when(statisticsMock.postsCount()).thenReturn(100);
    when(statisticsMock.commentsCount()).thenReturn(200);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertTrue(forumStatistics.getCommentCount() > forumStatistics.getPostCount());
    assertEquals(2.0, forumStatistics.getAvgCommentsPerPost());
}

@Test
void testZeroUsers() {
    when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
    when(statisticsMock.postsCount()).thenReturn(100);
    when(statisticsMock.commentsCount()).thenReturn(50);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertEquals(0, forumStatistics.getUserCount());
    assertEquals(0.0, forumStatistics.getAvgPostsPerUser());
    assertEquals(0.0, forumStatistics.getAvgCommentsPerUser());
}

@Test
void testHundredUsers() {
    when(statisticsMock.usersNames()).thenReturn(generateUsers(100));
    when(statisticsMock.postsCount()).thenReturn(100);
    when(statisticsMock.commentsCount()).thenReturn(200);

    forumStatistics.calculateAdvStatistics(statisticsMock);

    assertEquals(100, forumStatistics.getUserCount());
    assertEquals(1.0, forumStatistics.getAvgPostsPerUser());
    assertEquals(2.0, forumStatistics.getAvgCommentsPerUser());
}

private List<String> generateUsers(int count) {
        List<String> users = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            users.add("user" + i);
        }
        return users;
}
}
