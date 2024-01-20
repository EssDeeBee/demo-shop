package com.jpoint.demoshop.service.generators;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CommonGenerator {
    final Random random = new Random();

    public String generatePhone() {
        return String.valueOf(random.nextInt(0, 10)) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10);
    }

}
