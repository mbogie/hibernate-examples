package com.github.pabloo99.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "locations")
public class Locations {

    @Id
    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street_province")
    private String stateProvince;

    @Column(name = "country_id")
    private String countryId;
}
