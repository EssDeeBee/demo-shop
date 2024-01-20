package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.SellerRecord;
import com.jpoint.demoshop.service.generators.SellerGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class PopulationServiceTest {

    Random random = new Random();

    @Autowired
    SellerGenerator sellerGenerator;

    @Test
    void shouldGenerateSellerWhenMethodInvoked() {
        int numberOfItems = random.nextInt(1, 10_000);
        List<SellerRecord> items = new LinkedList<>();
        for (int i = 0; i < numberOfItems; i++) {
            items.add(sellerGenerator.generateSeller(random.nextInt(0, 100)));
        }
        items.forEach(System.out::println);
        System.out.println(items.size());
        Assertions.assertThat(items).isNotNull().hasSize(numberOfItems);
    }

}