package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.RegionRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegionGeneratorTest {

    @Autowired
    RegionGenerator regionGenerator;


    @Test
    void shouldGenerateRegionWhenMethodInvoked() {
        RegionRecord regionRecord = regionGenerator.generateRegion(null, 1,1, 1, 1);
        System.out.println(regionRecord);
        Assertions.assertThat(regionRecord).isNotNull();
    }

}