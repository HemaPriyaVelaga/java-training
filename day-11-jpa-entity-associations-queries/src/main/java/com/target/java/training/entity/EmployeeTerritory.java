package com.target.java.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "EMPLOYEE_TERRITORIES")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTerritory implements Serializable {
    /*
    +--------------+------+------+-----+---------+-------+
| Field        | Type | Null | Key | Default | Extra |
+--------------+------+------+-----+---------+-------+
| EMPLOYEE_ID  | int  | NO   | PRI | NULL    |       |
| TERRITORY_ID | int  | NO   | PRI | NULL    |       |
+--------------+------+------+-----+---------+-------+
     */

    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Id
    @Column(name = "TERRITORY_ID")
    private Integer territoryId;


    // One order has many line items, one line item belongs to one order
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", insertable = false, updatable = false)
    // Says not to use this field when updating the table
    // and to use the above product ID while updating
    private Employee employee;

    public EmployeeTerritory(Integer employeeId, Integer territoryId) {
        this.employeeId = employeeId;
        this.territoryId = territoryId;
    }

    @ManyToOne
    @JoinColumn(name = "TERRITORY_ID", insertable = false, updatable = false)
    private  Territory territory;
}
