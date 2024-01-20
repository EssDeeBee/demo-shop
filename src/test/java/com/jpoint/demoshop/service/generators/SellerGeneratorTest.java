package com.jpoint.demoshop.service.generators;


import com.jpoint.demoshop.model.SellerRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SellerGeneratorTest {

    @Autowired
    SellerGenerator sellerGenerator;

    @Test
    void shouldGenerateSellerWhenMethodInvoked() {
        SellerRecord sellerRecord = sellerGenerator.generateSeller(10, 1);
        System.out.println(sellerRecord);
        Assertions.assertThat(sellerRecord).isNotNull();
    }

}