package com.jpoint.demoshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "country")
public class CountryRecord extends BaseEntity {

    private String name;
    private String code;
    private String timezone;
    private String flagCode;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<RegionRecord> regions;
}
