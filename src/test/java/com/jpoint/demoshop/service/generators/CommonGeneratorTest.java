package com.jpoint.demoshop.service.generators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CommonGeneratorTest {

    @Autowired
    CommonGenerator commonGenerator;

    @Test
    void shouldGeneratePhoneNumberWhenInvoked() {
        String phone = commonGenerator.generatePhone();
        System.out.printf("%s \n", phone);
        Assertions.assertThat(phone).isNotNull().hasSizeGreaterThan(1);
    }

}