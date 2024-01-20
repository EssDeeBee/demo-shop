package com.jpoint.demoshop.model;

import jakarta.persistence.*;
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
