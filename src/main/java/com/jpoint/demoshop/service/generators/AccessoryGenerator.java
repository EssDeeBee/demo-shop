package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.AccessoryRecord;
import com.jpoint.demoshop.model.ItemRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccessoryGenerator {

    private final Random random = new Random();

    public AccessoryRecord generateAccessory(ItemRecord itemRecord) {
        var accessoryRecord = new AccessoryRecord();
        accessoryRecord.setId(null);
        accessoryRecord.setName(generateAccessoryName());
        accessoryRecord.setPrice(generatePrice());
        accessoryRecord.setDescription(generateDescription());
        accessoryRecord.setItemRecord(itemRecord);
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

    private String generateDescription() {
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
}
