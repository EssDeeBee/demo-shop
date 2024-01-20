package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.ShopRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopGeneratorTest {

    @Autowired
    ShopGenerator shopGenerator;


    @Test
    void shouldGenerateShopWhenMethodInvoked() {
        ShopRecord shopRecord = shopGenerator.generateShop(null);
        System.out.println(shopRecord);
        Assertions.assertThat(shopRecord).isNotNull();
    }
}