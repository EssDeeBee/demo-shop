package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.AccessoryRecord;
import com.jpoint.demoshop.model.ItemRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccessoryGenerator {

    private final Random random = new Random();

    private final CommonGenerator commonGenerator;

    public AccessoryRecord generateAccessory(ItemRecord itemRecord) {
        var accessoryRecord = new AccessoryRecord();
        accessoryRecord.setId(null);
        accessoryRecord.setName(generateAccessoryName());
        accessoryRecord.setPrice(commonGenerator.generatePrice());
        accessoryRecord.setDescription(commonGenerator.generateDescription());
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

}
