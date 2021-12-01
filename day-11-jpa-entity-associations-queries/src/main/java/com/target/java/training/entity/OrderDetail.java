package com.target.java.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor // Needed for em.find? (check GetCustomerWhoOrderedProduct.java code)
@Table(name = "ORDER_DETAILS")
// Rows in tables with composite Keys are called Line items

// We need to do implements serializable because
// Check out the code in GetOneLineItem.java
// There, if we pass such object to em.find, since it implements serializable
// by hibernate, it expects the object also to do the same
// So if not done, it throws an error
public class OrderDetail implements Serializable {

    /*

+------------+---------------+------+-----+---------+-------+
| Field      | Type          | Null | Key | Default | Extra |
+------------+---------------+------+-----+---------+-------+
| ORDER_ID   | int           | NO   | PRI | NULL    |       |
| PRODUCT_ID | int           | NO   | PRI | NULL    |       |
| UNIT_PRICE | decimal(19,4) | NO   |     | NULL    |       |
| QUANTITY   | int           | NO   |     | NULL    |       |
| DISCOUNT   | decimal(5,2)  | NO   |     | NULL    |       |
+------------+---------------+------+-----+---------+-------+

     */

    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;


    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private Integer discount;


    // One order has many line items, one line item belongs to one order
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
    // Says not to use this field when updating the table
    // and to use the above product ID while updating
    private Product product;

    public OrderDetail(Integer ordersId, Integer productId) {
        this.orderId = ordersId;
        this.productId = productId;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    private  Order order;
}
