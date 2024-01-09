package com.jpoint.demoshop.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "item")
public class ItemRecord {

    @Id
    private Long id;
    private String name;
    private Double price;
    private String description;

    @ManyToOne
    private SellerRecord sellerRecord;

    @OneToMany
    private List<AccessoryRecord> accessories;

}
