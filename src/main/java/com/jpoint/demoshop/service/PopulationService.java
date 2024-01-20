package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.*;
import com.jpoint.demoshop.repositories.ItemRecordCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class PopulationService {

    private final ItemRecordCrudRepository itemRecordCrudRepository;

    Random random = new Random();

    public PopulationService(ItemRecordCrudRepository itemRecordCrudRepository) {
        this.itemRecordCrudRepository = itemRecordCrudRepository;
    }

    @Transactional
    public void populateTables() {

        /*
      new AccessoryRecord();
        CountryRecord countryRecord = new CountryRecord();
        ItemRecord itemRecord = new ItemRecord();
        RegionRecord regionRecord = new RegionRecord();
        SellerRecord sellerRecord = new SellerRecord();
        ShopRecord shopRecord = new ShopRecord();
        */
        // int numberOfItems = 1_000_000;
        // int numberOfItems = 200_000;
        int numberOfItems = 1_000;
        List<ItemRecord> items = new LinkedList<>();
        for(int i =0; i< numberOfItems; i++) {
            items.add(generateItem());
        }
        // items.forEach(System.out::println);
        System.out.println(new Date());
        System.out.println(items.size());
        itemRecordCrudRepository.saveAll(items);
    }

    /*
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
     */

    private ItemRecord  generateItem(){
        ItemRecord itemRecord = new ItemRecord();
        itemRecord.setName(generateItemName());
        itemRecord.setPrice(generatePrice());
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

    private Double generatePrice() {
        return random.nextDouble(1, 1_000);
    }

    private AccessoryRecord generateAccessoryRecord() {
        var accessoryRecord = new AccessoryRecord();
        accessoryRecord.setName(generateAccessoryName());
        accessoryRecord.setDescription(generateDescription());
        accessoryRecord.setPrice(generatePrice());
        return accessoryRecord;
    }

    private String generateAccessoryName() {
        List<String> names = List.of(
                "Sticker",
                "Cabal",
                "Power bank",
                "Cover"
        );

        return names.get(random.nextInt(0, names.size()));
    }
}
