package com.target.java.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    /*
 +-------------------+-------------+------+-----+---------+-------+
| Field             | Type        | Null | Key | Default | Extra |
+-------------------+-------------+------+-----+---------+-------+
| EMPLOYEE_ID       | int         | NO   | PRI | NULL    |       |
| LAST_NAME         | varchar(10) | NO   |     | NULL    |       |
| FIRST_NAME        | varchar(10) | NO   |     | NULL    |       |
| TITLE             | varchar(25) | YES  |     | NULL    |       |
| TITLE_OF_COURTESY | varchar(5)  | YES  |     | NULL    |       |
| BIRTH_DATE        | datetime    | YES  |     | NULL    |       |
| HIRE_DATE         | datetime    | YES  |     | NULL    |       |
| ADDRESS           | varchar(30) | YES  |     | NULL    |       |
| CITY              | varchar(10) | YES  |     | NULL    |       |
| REGION            | varchar(2)  | YES  |     | NULL    |       |
| POSTAL_CODE       | varchar(10) | YES  |     | NULL    |       |
| COUNTRY           | varchar(10) | YES  |     | NULL    |       |
| HOME_PHONE        | varchar(15) | YES  |     | NULL    |       |
| EXTENSION         | varchar(5)  | YES  |     | NULL    |       |
| Photo             | longblob    | YES  |     | NULL    |       |
| NOTES             | longtext    | YES  |     | NULL    |       |
| REPORTS_TO        | int         | YES  |     | NULL    |       |
+-------------------+-------------+------+-----+---------+-------+
     */

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String title;

    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "hire_date")
    private Date hireDate;

    private String address;
    private String city;
    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @Column(name = "home_phone")
    private String homePhone;
    private String extension;

    private byte[] photo;

    @Lob
    private String notes;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @OneToMany
    @JoinColumn(name = "EMPLOYEE_ID")
    private List<EmployeeTerritory> employeeTerritoryList;

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", title='" + title + '\'' +
                ", titleOfCourtesy='" + titleOfCourtesy + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", extension='" + extension + '\'' +
                ", notes='" + notes + '\'' +
                ", reportsTo=" + reportsTo +
                '}';
    }
}
