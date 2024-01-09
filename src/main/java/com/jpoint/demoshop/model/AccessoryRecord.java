package com.jpoint.demoshop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accessory")
public class AccessoryRecord {

    @Id
    private Long id;
    private String name;
    private Double price;
    private String description;


    @ManyToOne
    private ItemRecord itemRecord;
}
