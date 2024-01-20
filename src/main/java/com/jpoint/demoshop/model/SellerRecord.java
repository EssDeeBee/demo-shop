package com.jpoint.demoshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "seller")
public class SellerRecord extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<ItemRecord> items;
}
