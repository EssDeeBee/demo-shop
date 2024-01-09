package com.jpoint.demoshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "seller")
public class SellerRecord {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @OneToMany
    private Set<ItemRecord> items;
}
