package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.RegionRecord;
import com.jpoint.demoshop.model.SellerRecord;
import com.jpoint.demoshop.model.ShopRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShopGenerator {

    private final Random random = new Random();
    private final CommonGenerator commonGenerator;
    private final SellerGenerator sellerGenerator;


    public ShopRecord generateShop(RegionRecord regionRecord, int itemCount, int accessoriesCount) {
        String shopName = generateShopName();

        ShopRecord shopRecord = new ShopRecord();
        shopRecord.setId(null);
        shopRecord.setName(generateShopName());
        shopRecord.setAddress(generateAddress());
        shopRecord.setEmail(generateEmail(shopName));
        shopRecord.setPhone(commonGenerator.generatePhone());
        shopRecord.setRegionRecord(regionRecord);
        shopRecord.setSellers(generateSellers(itemCount, accessoriesCount));
        return shopRecord;
    }

    private Set<SellerRecord> generateSellers(int itemCount, int accessoriesCount) {
        Set<SellerRecord> sellers = new HashSet<>();
        int sellersNumber = random.nextInt(0, 1_000);
        for (int i = 0; i < sellersNumber; i++) {
            sellers.add(sellerGenerator.generateSeller(itemCount, accessoriesCount));
        }
        return sellers;
    }

    private String generateShopName() {
        List<String> shopNames = List.of(
                "Bluebell Boutique",
                "The Gadget Grove",
                "Mystic Pages Bookstore",
                "Java Jive Café",
                "Wandering Willow Florist",
                "Urban Oasis Spa",
                "Whisk & Wooden Spoon Bakery",
                "The Crystal Corner",
                "Paws & Claws Pet Shop",
                "Sunset Studio Art Supplies",
                "The Vintage Vault Clothing",
                "The Green Leaf Health Food Store",
                "Starry Night Music Shop",
                "The Cozy Nook Bookshop",
                "Seaside Treasures Gift Shop",
                "Rainbow Threads Fabric Store",
                "Rocket Sports Goods",
                "The Golden Griddle Kitchenware",
                "The Toy Tower",
                "Serenity Soap Co."
        );
        return shopNames.get(random.nextInt(0, shopNames.size()));
    }

    private String generateAddress() {
        List<String> addresses = List.of(
                "123 Maple Street, Springfield, IL",
                "456 Oak Avenue, Riverdale, NY",
                "789 Pine Lane, Lakeside, FL",
                "1010 Birch Road, Star City, CA",
                "1112 Cedar Path, Brookfield, TX",
                "1314 Elm Drive, Hill Valley, PA",
                "1516 Willow Way, Sunnydale, WA",
                "1718 Aspen Court, Green Grove, MN",
                "1920 Hawthorn Terrace, Blackwood, NJ",
                "2122 Alder Boulevard, Redwood, OR",
                "2324 Sycamore Street, Pine Hill, VA",
                "2526 Juniper Lane, Silver Lake, CO",
                "2728 Magnolia Avenue, Crescent Bay, NC",
                "2930 Cherry Circle, Oakwood, MA",
                "3132 Beechwood Drive, Whispering Pines, NV",
                "3334 Dogwood Road, Liberty Town, OH",
                "3536 Spruce Street, Eden Prairie, AZ",
                "3738 Myrtle Avenue, Little Rock, MI",
                "3940 Locust Lane, New Haven, MO",
                "4142 Ironwood Road, Grandview, GA"
        );
        return addresses.get(random.nextInt(0, addresses.size()));
    }

    private String generateEmail(@NonNull String shopName) {
        return shopName.replace(" ", "_").toLowerCase();
    }

}
