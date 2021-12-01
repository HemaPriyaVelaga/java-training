package com.target.java.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "TERRITORIES")
public class Territory {
    /*
    +-----------------------+-------------+------+-----+---------+-------+
| Field                 | Type        | Null | Key | Default | Extra |
+-----------------------+-------------+------+-----+---------+-------+
| TERRITORY_ID          | int         | NO   | PRI | NULL    |       |
| TERRITORY_DESCRIPTION | varchar(50) | NO   |     | NULL    |       |
| REGION_ID             | int         | NO   | MUL | NULL    |       |
+-----------------------+-------------+------+-----+---------+-------+
     */

    @Id
    @Column(name = "territory_id")
    private Integer territoryId;

    @Column(name = "territory_description")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region regionId; // region

    @OneToMany
    @JoinColumn(name = "territory_id")
    private List<EmployeeTerritory> employeeTerritoryList;

    @Override
    public String toString() {
        return "Territory{" +
                "territoryId=" + territoryId +
                ", territoryDescription='" + territoryDescription + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
