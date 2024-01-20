package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.ItemRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ItemGeneratorTest {

    @Autowired
    ItemGenerator itemGenerator;


    @Test
    void shouldGenerateItemsWhenMethodInvoked() {
        ItemRecord itemRecord = itemGenerator.generateItem(null, 1);
        System.out.println(itemRecord);
        Assertions.assertThat(itemRecord).isNotNull();
    }
}