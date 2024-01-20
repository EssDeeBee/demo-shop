package com.jpoint.demoshop.service.generators;


import com.jpoint.demoshop.model.CountryRecord;
import com.jpoint.demoshop.model.RegionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CountryGenerator {
    private final Random random = new Random();

    private final RegionGenerator regionGenerator;

    public CountryRecord generateCountry(int regionCount, int shopCount, int itemCount, int sellerCount, int accessoriesCount) {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setId(null);
        countryRecord.setName(generateCountryName());
        countryRecord.setCode(generateCountryCode());
        countryRecord.setTimezone(generateTimezone());
        countryRecord.setFlagCode(generateCountryFlagCode());
        countryRecord.setRegions(generateRegions(countryRecord, regionCount, shopCount, sellerCount, itemCount, accessoriesCount));

        return countryRecord;
    }

    private Set<RegionRecord> generateRegions(CountryRecord countryRecord, int regionCount, int shopCount, int sellerCount, int itemCount, int accessoriesCount) {
        Set<RegionRecord> regions = new HashSet<>();
        for (int i = 0; i < regionCount; i++) {
            regions.add(regionGenerator.generateRegion(countryRecord, shopCount, sellerCount, itemCount, accessoriesCount));
        }

        return regions;
    }

    private String generateCountryName() {
        List<String> countryNames = List.of(
                "Auroria",
                "Zephyria",
                "Celestina",
                "Dravania",
                "Eldoria",
                "Marvania",
                "Thaloria",
                "Veritasia",
                "Oceania",
                "Nebulon"
        );
        return countryNames.get(random.nextInt(0, countryNames.size()));
    }

    private String generateCountryCode() {
        List<String> countryCodes = List.of(
                "AXY",
                "BZL",
                "CDE",
                "FKG",
                "GHI",
                "JKL",
                "MNO",
                "PQR",
                "STU",
                "VWX"
        );

        return countryCodes.get(random.nextInt(0, countryCodes.size()));
    }

    private String generateTimezone() {
        List<String> countryTimeZones = List.of(
                "UTC-5:00 United States (Eastern Time)",
                "UTC+1:00 Germany (Central European Time)",
                "UTC+9:00 Japan (Japan Standard Time)",
                "UTC+3:00 Russia (Moscow Time)",
                "UTC-3:00 Brazil (Brasília Time)",
                "UTC+5:30 India (Indian Standard Time)",
                "UTC+8:00 China (China Standard Time)",
                "UTC+10:00 Australia (Australian Eastern Standard Time)",
                "UTC+2:00 Egypt (Eastern European Time)",
                "UTC-8:00 Canada (Pacific Time)"
        );

        return countryTimeZones.get(random.nextInt(0, countryTimeZones.size()));
    }

    private String generateCountryFlagCode() {
        List<String> countryFlagCodes = List.of(
                "AX",
                "BR",
                "CU",
                "DT",
                "EP",
                "FQ",
                "GS",
                "HV",
                "IZ",
                "JL"
        );

        return countryFlagCodes.get(random.nextInt(0, countryFlagCodes.size()));
    }
}
