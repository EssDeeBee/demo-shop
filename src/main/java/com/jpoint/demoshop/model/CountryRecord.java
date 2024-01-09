package com.jpoint.demoshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "country")
public class CountryRecord {

    @Id
    private Long id;

    private String name;
    private String code;
    private String timezone;
    private String flagCode;

    @OneToMany
    private Set<RegionRecord> regions;
}
