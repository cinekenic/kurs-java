package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@NamedQuery(
        name = "Employee.findByLastName",
        query = "FROM Employee WHERE lastName = :LASTNAME"
)
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
