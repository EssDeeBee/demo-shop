package com.jpoint.demoshop.service.generators;

import com.jpoint.demoshop.model.CountryRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CountryGeneratorTest {

    @Autowired
    CountryGenerator countryGenerator;


    @Test
    void shouldGenerateCountryWhenMethodInvoked() {
        CountryRecord countryRecord = countryGenerator.generateCountry(1, 1, 1, 1);
        System.out.println(countryRecord);
        Assertions.assertThat(countryRecord).isNotNull();
    }

}