package com.training.customerservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private String  customerId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_TITLE")
    private String contactTitle;

    @Embedded
    private Address address;
    // Just for being able to reuse the class for multiple tables

    private String phone;

    private String fax;

    // Variable we require here but not in Database
    @Transient
    private String email; // Attempts to map to an existing column - gives error or creates new column
    // To avoid this, use @Transient
    // Hibernate will ignore this field
}
