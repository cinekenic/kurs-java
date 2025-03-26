package com.kodilla.hibernate.tasklist;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "LISTNAME")
    private String listName;

    @Column(name = "DESCRIPTION")
    private String description;

    public TaskList() {}

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    public String getDescription() {
        return description;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskList)) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(getListName(), taskList.getListName()) &&
                Objects.equals(getDescription(), taskList.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListName(), getDescription());
    }
}
