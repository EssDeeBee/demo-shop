package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.*;
import com.jpoint.demoshop.service.generators.ItemGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopulationService {

    private final ItemGenerator itemGenerator;


    public void populateTables() {

        new AccessoryRecord();
        CountryRecord countryRecord = new CountryRecord();
        RegionRecord regionRecord = new RegionRecord();
        ShopRecord shopRecord = new ShopRecord();
        SellerRecord sellerRecord = new SellerRecord();
        ItemRecord itemRecord = new ItemRecord();

    }


}
