package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.ItemRecord;
import com.jpoint.demoshop.model.SellerRecord;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SellerGenerator {
    private final Random random = new Random();
    private final CommonGenerator commonGenerator = new CommonGenerator();

    @Resource
    private ItemGenerator itemGenerator;

    public SellerRecord generateSeller(int itemCount) {
        String firstName = generateFirstName();
        String lastName = generateLastName();

        SellerRecord sellerRecord = new SellerRecord();
        sellerRecord.setId(null);
        sellerRecord.setFirstName(generateFirstName());
        sellerRecord.setLastName(generateLastName());
        sellerRecord.setEmail(firstName + "-" + lastName + "@mail.com");
        sellerRecord.setPhone(commonGenerator.generatePhone());
        sellerRecord.setItems(generateItems(sellerRecord, itemCount));

        return sellerRecord;
    }

    private Set<ItemRecord> generateItems(SellerRecord sellerRecord, int count) {
        Set<ItemRecord> items = new HashSet<>();
        int itemsNumber = random.nextInt(0, 100);

        for (int i = 0; i < count; i++) {
            items.add(itemGenerator.generateItem(sellerRecord));
        }

        return items;
    }

    private String generateFirstName() {
        List<String> names = List.of(
                "Emma",
                "Noah",
                "Olivia",
                "Liam",
                "Sophia",
                "Ethan",
                "Ava",
                "Mason",
                "Mia",
                "Jacob"
        );

        return names.get(random.nextInt(0, names.size()));
    }

    private String generateLastName() {
        List<String> lastNames = List.of(
                "Smith",
                "Johnson",
                "Williams",
                "Brown",
                "Jones",
                "Garcia",
                "Miller",
                "Davis",
                "Rodriguez",
                "Martinez"
        );

        return lastNames.get(random.nextInt(0, lastNames.size()));
    }

}
