package com.jpoint.demoshop.service;


import com.jpoint.demoshop.model.SellerRecord;
import com.jpoint.demoshop.service.generators.SellerGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class PopulationServiceTest {

    Random random = new Random();

    @Autowired
    SellerGenerator sellerGenerator;

    @Test
    void shouldGenerateSellerWhenMethodInvoked() {
        SellerRecord sellerRecord = sellerGenerator.generateSeller(10, 1);
        System.out.println(sellerRecord);
        Assertions.assertThat(sellerRecord).isNotNull();
    }

}