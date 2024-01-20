package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.AccessoryRecord;
import com.jpoint.demoshop.model.ItemRecord;
import com.jpoint.demoshop.model.SellerRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ItemGenerator {
    private final Random random = new Random();
    private final AccessoryGenerator accessoryGenerator;
    private final CommonGenerator commonGenerator;

    public ItemRecord generateItem(SellerRecord sellerRecord, int accessoriesNumber) {
        ItemRecord itemRecord = new ItemRecord();
        itemRecord.setId(null);
        itemRecord.setName(generateItemName());
        itemRecord.setPrice(commonGenerator.generatePrice());
        itemRecord.setDescription(commonGenerator.generateDescription());
        itemRecord.setSellerRecord(sellerRecord);

        var accessories = new ArrayList<AccessoryRecord>();
        for (int i = 0; i < accessoriesNumber; i++) {
            accessories.add(accessoryGenerator.generateAccessory(itemRecord));
        }
        itemRecord.setAccessories(accessories);

        return itemRecord;
    }

    private String generateItemName() {
        List<String> items = List.of(
                "TV",
                "PC",
                "Laptop",
                "Cooler stand",
                "PS5"
        );

        return items.get(random.nextInt(0, items.size()));
    }

}
