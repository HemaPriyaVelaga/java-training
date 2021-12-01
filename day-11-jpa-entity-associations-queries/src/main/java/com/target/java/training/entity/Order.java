package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    /*

    +------------------+---------------+------+-----+---------+-------+
| Field            | Type          | Null | Key | Default | Extra |
+------------------+---------------+------+-----+---------+-------+
| ORDER_ID         | int           | NO   | PRI | NULL    |       |
| CUSTOMER_ID      | varchar(5)    | YES  | MUL | NULL    |       |
| EMPLOYEE_ID      | int           | YES  | MUL | NULL    |       |
| ORDER_DATE       | datetime      | YES  |     | NULL    |       |
| REQUIRED_DATE    | datetime      | YES  |     | NULL    |       |
| SHIPPED_DATE     | datetime      | YES  |     | NULL    |       |
| SHIP_VIA         | int           | YES  |     | NULL    |       |
| FREIGHT          | decimal(19,4) | YES  |     | NULL    |       |
| SHIP_NAME        | varchar(40)   | YES  |     | NULL    |       |
| SHIP_ADDRESS     | varchar(75)   | YES  |     | NULL    |       |
| SHIP_CITY        | varchar(20)   | YES  |     | NULL    |       |
| SHIP_REGION      | varchar(20)   | YES  |     | NULL    |       |
| SHIP_POSTAL_CODE | varchar(10)   | YES  |     | NULL    |       |
| SHIP_COUNTRY     | varchar(20)   | YES  |     | NULL    |       |
+------------------+---------------+------+-----+---------+-------+
14 rows in set (0.00 sec)

     */
    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

//
//    @Column(name = "ship_via")
//    private Integer ship_via;

    @Column(name = "FREIGHT")
    private Double freight;

    @Column(name = "SHIP_NAME")
    private String shipName;

    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;

    @Column(name = "SHIP_CITY")
    private String shipCity;

    @Column(name = "SHIP_REGION")
    private String shipRegion;

    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;

    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<OrderDetail> lineItems;

    @ManyToOne
    @JoinColumn(name = "SHIP_VIA")
    private Shipper shipper;
    // Since multiple orders are associated with single shipper

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
//                ", ship_via=" + ship_via +
                ", freight=" + freight +
                ", shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", customer=" + customer +
//                ", shipper=" + shipper +
                '}';
    }
}
