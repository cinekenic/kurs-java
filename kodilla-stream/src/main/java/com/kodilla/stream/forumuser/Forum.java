package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<ForumUser>();

    public Forum() {
        userList.add(new ForumUser(1, "JohnDoe", 'M', LocalDate.of(2000, 5, 15), 5));
        userList.add(new ForumUser(2, "JaneDoe", 'F', LocalDate.of(1998, 8, 21), 10));
        userList.add(new ForumUser(3, "MarkSmith", 'M', LocalDate.of(2005, 3, 10), 0));
        userList.add(new ForumUser(4, "LucyAdams", 'F', LocalDate.of(1995, 7, 5), 3));
        userList.add(new ForumUser(5, "TomBrown", 'M', LocalDate.of(1990, 1, 25), 7));
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
