package com.training.orderservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="ORDERS")
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;
    private Double freight;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private List<LineItem> items;

    @Transient // JPA doesnt care about this
    private Customer customer;
}
