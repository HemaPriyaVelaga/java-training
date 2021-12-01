package com.training.employeeservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private byte[] photo;

    @Lob
    private String notes;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", lastName='" + lastName + '\'' +
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

    @JsonProperty("photo")
    public byte[] getPhoto() {
        return photo;
    }

    @JsonIgnore
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "reports_to")
    private Integer reportsTo;
}
