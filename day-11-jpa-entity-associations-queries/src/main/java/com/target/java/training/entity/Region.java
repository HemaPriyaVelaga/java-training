package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "REGIONS")
public class Region {

    /*
    +--------------------+-------------+------+-----+---------+-------+
| Field              | Type        | Null | Key | Default | Extra |
+--------------------+-------------+------+-----+---------+-------+
| REGION_ID          | int         | NO   | PRI | NULL    |       |
| REGION_DESCRIPTION | varchar(50) | NO   |     | NULL    |       |
+--------------------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

     */
    @Id
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_description")
    private String regionDescription;


    @OneToMany
    @JoinColumn(name = "region_id") // PRODUCTS.CATEGORY_ID
    private List<Territory> territories;

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionDescription='" + regionDescription + '\'' +
                '}';
    }
}
