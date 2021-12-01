package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
/*
+-------------------+---------------+------+-----+---------+-------+
| Field             | Type          | Null | Key | Default | Extra |
+-------------------+---------------+------+-----+---------+-------+
| PRODUCT_ID        | int           | NO   | PRI | NULL    |       |
| PRODUCT_NAME      | varchar(50)   | NO   |     | NULL    |       |
| SUPPLIER_ID       | int           | YES  | MUL | NULL    |       |
| CATEGORY_ID       | int           | YES  | MUL | NULL    |       |
| QUANTITY_PER_UNIT | varchar(50)   | YES  |     | NULL    |       |
| UNIT_PRICE        | decimal(19,4) | YES  |     | NULL    |       |
| UNITS_IN_STOCK    | int           | YES  |     | NULL    |       |
| UNITS_ON_ORDER    | int           | YES  |     | NULL    |       |
| REORDER_LEVEL     | int           | YES  |     | NULL    |       |
| DISCONTINUED      | int           | NO   |     | NULL    |       |
+-------------------+---------------+------+-----+---------+-------+

 */
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "QUANTITY_PER_UNIT")
    private String quantityPerUnit;

    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "UNITS_IN_STOCK")
    private Integer unitsInStock;

    @Column(name = "UNITS_ON_ORDER")
    private Integer unitsOnOrder;

    @Column(name = "REORDER_LEVEL")
    private Integer reorderLevel;

    @Column(name = "DISCONTINUED")
    private Integer discontinued;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    // Since many products have same category and each category has many products

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;


    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<OrderDetail> lineItems;

}
