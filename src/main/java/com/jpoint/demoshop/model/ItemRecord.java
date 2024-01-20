package com.jpoint.demoshop.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "item")
public class ItemRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private String description;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SellerRecord sellerRecord;

    @OneToMany
    private List<AccessoryRecord> accessories;

}
