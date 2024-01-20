package com.jpoint.demoshop.service.generators;


import com.jpoint.demoshop.model.CountryRecord;
import com.jpoint.demoshop.model.RegionRecord;
import com.jpoint.demoshop.model.ShopRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegionGenerator {
    private final Random random = new Random();

    private final ShopGenerator shopGenerator;

    public RegionRecord generateRegion(CountryRecord countryRecord, int shopCount, int sellerCount, int itemCount, int accessoriesCount) {
        RegionRecord regionRecord = new RegionRecord();
        regionRecord.setId(null);
        regionRecord.setName(generateName());
        regionRecord.setLocation(generateLocationName());
        regionRecord.setCountryRecord(countryRecord);
        regionRecord.setShops(generateShops(regionRecord, shopCount, sellerCount, itemCount, accessoriesCount));

        return regionRecord;
    }

    private Set<ShopRecord> generateShops(RegionRecord regionRecord, int shopCount, int sellerCount, int itemCount, int accessoriesCount) {
        Set<ShopRecord> shops = new HashSet<>();
        for (int i = 0; i < shopCount; i++) {
            shops.add(shopGenerator.generateShop(regionRecord, sellerCount, itemCount, accessoriesCount));
        }

        return shops;
    }

    private String generateName() {
        List<String> regionNames = List.of(
                "Emerald Highlands",
                "Silverwood Valley",
                "Crimson Canyon",
                "Azure Shore",
                "Golden Plains",
                "Mystic Peaks",
                "Whispering Pines",
                "Twilight Forest",
                "Sapphire Isles",
                "Ruby Desert"
        );

        return regionNames.get(random.nextInt(0, regionNames.size()));

    }

    private String generateLocationName() {
        List<String> locationNames = List.of(
                "Frostfall Mountains",
                "Lunar Lake",
                "Sundown Village",
                "Starlight City",
                "Whisperwind Bay",
                "Evergreen Oasis",
                "Mirage Island",
                "Ravenwood Forest",
                "Solstice Valley",
                "Eclipse Harbor"
        );
        return locationNames.get(random.nextInt(0, locationNames.size()));
    }
}
