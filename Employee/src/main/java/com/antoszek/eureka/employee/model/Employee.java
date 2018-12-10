package com.antoszek.eureka.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "employee")
//    @JoinColumn(nullable = false)
    private Set<Office> offices;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, Set<Office> offices) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.offices = offices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", offices=" + offices +
                '}';
    }
}