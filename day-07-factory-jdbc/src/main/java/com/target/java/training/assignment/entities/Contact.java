package com.target.java.training.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    private int id;
    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    private String email;
    private String phone;
    private String address;
    private String city = "Bangalore";
    private String state = "Karnataka";
    private Integer pincode;
    private String country = "India";
    private Date birthDate;
}