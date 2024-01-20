package com.jpoint.demoshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;


@Data
@Entity
@Table(name = "region")
public class RegionRecord extends BaseEntity {

    private String name;
    private String location;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CountryRecord countryRecord;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ShopRecord> shops;
}
