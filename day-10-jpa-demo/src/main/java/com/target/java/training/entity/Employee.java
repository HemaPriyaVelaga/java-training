package com.target.java.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // Now, this class as a manageable class by EntityManager
@Table(name = "employees")
public class Employee {

    @Id // Mandatory with and without GeneratedValue
    // If not specified, it will throw an error saying ID is not found
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increments id in table
    private Integer id;
    private String name;

    @Column(name = "hire_date")
    // It will add a new col (other than hireDate) if the earlier created table is not dropped
    private Date hireDate;
    private Double Salary;

    @Column(unique = true) // to say that this column must be unique per row
    private String email;

    private String city;
    private String state;
    private String country;



    public Employee(String name, Double salary, String email) {
        this.name = name;
        Salary = salary;
        this.email = email;
    }

    public Employee(String name, Double salary) {
        this.name = name;
        Salary = salary;
    }

    public Employee(Integer id, String name, Date hireDate, Double salary, String email) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        Salary = salary;
        this.email = email;
    }
}

// To tell hibernate that there is an object called Employee
// and to add it to the DB
// cmd + shift + t, search entity manager, and check the crud operations
// These crud operations can be performed only on Entity class object
// by the entity manager
// So, add @Entity above the class

// It also maps this class to a table called Employee by default
// If we have any table other than Employee, into which we want to add
// employee data, do the following
// @Table(name = "employees")
// This table must have a primary key, so add @Id above the variable which
// we want to use are PK in the table


// TO automatically add the primary key using hibernate:
// add @GeneratedValue(startegy = ...)
// There are several options like auto increment, table using seed values,
// sequence (not supported by SQL)
// but for the changes to reflect, drop the earlier generated tables
