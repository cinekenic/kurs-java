package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "COMPANIES")
@NamedNativeQuery(
        name = "Company.findByFirstThreeLetters",
        query = "SELECT * FROM COMPANIES  WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :PREFIX",
        resultClass = Company.class
)
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<Employee>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

@ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }
}
