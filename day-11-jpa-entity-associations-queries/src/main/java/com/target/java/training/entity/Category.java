package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category {

    /*
    +---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| CATEGORY_ID   | int         | NO   | PRI | NULL    |       |
| CATEGORY_NAME | varchar(20) | NO   |     | NULL    |       |
| DESCRIPTION   | varchar(60) | YES  |     | NULL    |       |
| PICTURE       | longblob    | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+
     */


    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    private String description;
    private byte[] picture;

    // Object Relational Mapping
    // i.e., mapping Java Object to RDBMS
    @OneToMany
    @JoinColumn(name = "category_id") // PRODUCTS.CATEGORY_ID
    private List<Product> productList;
    // Hibernate throws error by default as it will try to map it to a column in the table
    // To prevent that, we need to tell that it is related to PRODUCT table
    // Using the above @ notations


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    // If we dont override this ToString method, it prints the products of category
    // and in products, it will come across the product category
    // and again print products in that category
    // and so on, and will go into an infinite loop
    // And will finally throw a "Stack Overflow error"

}
