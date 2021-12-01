package com.training.shippersservice.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SHIPPERS")
public class Shipper {


    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "shipper_id")
    private Integer shipperId;
    // One shipper id ships multiple orders

    @Column(name = "company_name")
    private String companyName;

    private String phone;

}
