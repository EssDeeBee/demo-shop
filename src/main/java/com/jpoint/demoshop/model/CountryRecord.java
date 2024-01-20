package com.jpoint.demoshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "country")
public class CountryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String code;
    private String timezone;
    private String flagCode;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<RegionRecord> regions;
}
