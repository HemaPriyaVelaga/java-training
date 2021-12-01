package com.training.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Transient;

@Data
@NoArgsConstructor
public class Customer {

    //@JsonIgnore
    //@Column(name="CUSTOMER_ID")

    private String customerId;

    private String companyName;
    private String contactName;
    private String contactTitle;
    private Address address;
    private String phone;
    private String fax;

}
