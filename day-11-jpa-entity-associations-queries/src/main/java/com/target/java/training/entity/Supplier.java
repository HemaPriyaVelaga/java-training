package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SUPPLIERS")
public class Supplier {
    /*
    +---------------+--------------+------+-----+---------+-------+
| Field         | Type         | Null | Key | Default | Extra |
+---------------+--------------+------+-----+---------+-------+
| SUPPLIER_ID   | int          | NO   | PRI | NULL    |       |
| COMPANY_NAME  | varchar(50)  | NO   |     | NULL    |       |
| CONTACT_NAME  | varchar(30)  | YES  |     | NULL    |       |
| CONTACT_TITLE | varchar(30)  | YES  |     | NULL    |       |
| ADDRESS       | varchar(75)  | YES  |     | NULL    |       |
| CITY          | varchar(20)  | YES  |     | NULL    |       |
| REGION        | varchar(10)  | YES  |     | NULL    |       |
| POSTAL_CODE   | varchar(10)  | YES  |     | NULL    |       |
| COUNTRY       | varchar(20)  | YES  |     | NULL    |       |
| PHONE         | varchar(20)  | YES  |     | NULL    |       |
| FAX           | varchar(20)  | YES  |     | NULL    |       |
| HOME_PAGE     | varchar(120) | YES  |     | NULL    |       |
+---------------+--------------+------+-----+---------+-------+
     */

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "SUPPLIER_ID")
    private Integer supplierId;

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

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", homePage='" + homePage + '\'' +
                '}';
    }

    @Column(name = "FAX")
    private String fax;

    @Column(name = "HOME_PAGE")
    private String homePage;


    @OneToMany
    @JoinColumn(name = "SUPPLIER_ID") // PRODUCTS.SUPPLIER_ID
    private List<Product> productList;



}
