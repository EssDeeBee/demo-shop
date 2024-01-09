package com.jpoint.demoshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "region")
public class RegionRecord {

    @Id
    private Long id;
    private String name;
    private String location;

    @ManyToOne
    private CountryRecord countryRecord;

    @OneToMany
    private Set<ShopRecord> shops;
}
