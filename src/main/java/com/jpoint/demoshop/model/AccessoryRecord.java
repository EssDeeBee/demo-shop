package com.jpoint.demoshop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "accessory")
public class AccessoryRecord extends BaseEntity {

    private String name;
    private Double price;
    private String description;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ItemRecord itemRecord;
}
