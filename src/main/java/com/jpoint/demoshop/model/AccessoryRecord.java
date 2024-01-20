package com.jpoint.demoshop.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "accessory")
public class AccessoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private String description;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemRecord itemRecord;
}
