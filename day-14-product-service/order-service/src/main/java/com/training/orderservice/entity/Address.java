package com.training.orderservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable // Object of this class can be used as an embedded member of an entity class
public class Address {

    @Column(name = "SHIP_ADDRESS")
    private String streetAddress;

    @Column(name = "SHIP_CITY")
    private String city;

    @Column(name = "SHIP_REGION")
    private String region;

    @Column(name = "SHIP_POSTAL_CODE")
    private String postalCode;

    @Column(name = "SHIP_COUNTRY")
    private String country;

}
