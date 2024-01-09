package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class PopulationService {

    Random random = new Random();

    public void populateTables(){

      new AccessoryRecord();
        CountryRecord countryRecord = new CountryRecord();
        ItemRecord itemRecord = new ItemRecord();
        RegionRecord regionRecord = new RegionRecord();
        SellerRecord sellerRecord = new SellerRecord();
        ShopRecord shopRecord = new ShopRecord();

    }

    public static void main(String... args){
        int numberOfItems = 1_000_000;
        PopulationService populationService = new PopulationService();
        List<ItemRecord> items = new LinkedList<>();
        for(int i =0; i< numberOfItems; i++){
            items.add(populationService.generateItem());
        }
        items.forEach(System.out::println);
        System.out.println(items.size());
    }

    private ItemRecord  generateItem(){
        ItemRecord itemRecord = new ItemRecord();
        itemRecord.setName(generateItemName());
        itemRecord.setPrice(random.nextDouble(1, 1_000));
        itemRecord.setDescription(generateDescription());
        itemRecord.setSellerRecord(null);
        itemRecord.setAccessories(List.of());

        return itemRecord;
    }

    private String generateItemName(){
        List<String> items = List.of(
                "TV",
                "PC",
                "Laptop",
                "Cooler stand",
                "PS5"
        );

       return items.get(random.nextInt(0, items.size()));
    }

    private String generateDescription(){
        List<String> descriptions = List.of(
                "Is very good",
                "Is very fast",
                "Is very cool",
                "Too expensive",
                "Amazing!"
        );

        return descriptions.get(random.nextInt(0, descriptions.size()));
    }


}
