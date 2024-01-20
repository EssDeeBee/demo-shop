package com.jpoint.demoshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;


@Data
@Entity
@Table(name = "shop")
public class ShopRecord extends BaseEntity {

    private String name;
    private String address;
    private String email;
    private String phone;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RegionRecord regionRecord;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<SellerRecord> sellers;
}
