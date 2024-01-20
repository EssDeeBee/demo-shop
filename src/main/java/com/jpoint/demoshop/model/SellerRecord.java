package com.jpoint.demoshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Data
@Entity
@Table(name = "seller")
public class SellerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<ItemRecord> items;
}
