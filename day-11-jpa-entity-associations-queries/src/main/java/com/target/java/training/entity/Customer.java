package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
/*
+---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| CUSTOMER_ID   | varchar(5)   | NO   | PRI | NULL    |       |
| COMPANY_NAME  | varchar(40)  | NO   |     | NULL    |       |
| CONTACT_NAME  | varchar(30)  | YES  |     | NULL    |       |
| CONTACT_TITLE | varchar(30)  | YES  |     | NULL    |       |
| ADDRESS       | varchar(75)  | YES  |     | NULL    |       |
| CITY          | varchar(255) | YES  |     | NULL    |       |
| REGION        | varchar(20)  | YES  |     | NULL    |       |
| POSTAL_CODE   | varchar(10)  | YES  |     | NULL    |       |
| COUNTRY       | varchar(15)  | YES  |     | NULL    |       |
| PHONE         | varchar(20)  | YES  |     | NULL    |       |
| FAX           | varchar(20)  | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+

 */
    @Id
    @Column(name = "CUSTOMER_ID")
    private String  customerId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_TITLE")
    private String contactTitle;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "REGION")
    private String region;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;
}
