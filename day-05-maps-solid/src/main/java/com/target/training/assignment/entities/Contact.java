package com.target.java.training.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    private int id;
    private String firstname;
    private String lastname;
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

