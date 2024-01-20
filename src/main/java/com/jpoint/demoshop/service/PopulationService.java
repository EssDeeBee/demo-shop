package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.CountryRecord;
import com.jpoint.demoshop.repositories.CountryRecordRepository;
import com.jpoint.demoshop.repositories.SellerRecordCrudRepository;
import com.jpoint.demoshop.service.generators.CountryGenerator;
import com.jpoint.demoshop.service.generators.SellerGenerator;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PopulationService {

    private final CountryGenerator countryGenerator;
    private final CountryRecordRepository countryRecordRepository;

    @Resource
    private SellerRecordCrudRepository sellerRecordCrudRepository;

    @Resource
    private SellerGenerator sellerGenerator;

    private final Random random = new Random();

    public void populateCountries(){
        CountryRecord countryRecord = countryGenerator.generateCountry(1, 2, 3, 3, 5);
        countryRecordRepository.save(countryRecord);
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
        int numberOfAccessories = 5;
        sellerRecordCrudRepository.save(sellerGenerator.generateSeller(numberOfItems, numberOfAccessories));
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
