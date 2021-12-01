package com.target.java.training.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

// Ship_via in ORDERS table = Shipper_id in SHIPPERS table
@Data
@Entity
@Table(name = "SHIPPERS")
public class Shipper {

    /*
    +--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| SHIPPER_ID   | int         | NO   | PRI | NULL    |       |
| COMPANY_NAME | varchar(20) | NO   |     | NULL    |       |
| PHONE        | varchar(20) | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
     */

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "shipper_id")
    private Integer shipperId;
    // One shipper id ships multiple orders

    @Column(name = "company_name")
    private String companyName;

   // @Column(name = "phone") This need ot be added here as the column name is same as the variable name
    private String phone;

    @OneToMany(mappedBy = "shipper")
    //@JoinColumn(name = "ship_via") // ORDERS.SHIP_VIA
    private List<Order> orderList;

    @Override
    public String toString() {
        return "Shipper{" +
                "shipperId=" + shipperId +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

