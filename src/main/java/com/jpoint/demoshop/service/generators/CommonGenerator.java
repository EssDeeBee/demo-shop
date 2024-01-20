package com.jpoint.demoshop.service.generators;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CommonGenerator {
    private final Random random = new Random();

    public String generatePhone() {
        return String.valueOf(random.nextInt(0, 10)) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10) +
                random.nextInt(0, 10);
    }

    public String generateDescription() {
        List<String> descriptions = List.of(
                "Is very good",
                "Is very fast",
                "Is very cool",
                "Too expensive",
                "Amazing!"
        );

        return descriptions.get(random.nextInt(0, descriptions.size()));
    }

    public Double generatePrice() {
        return random.nextDouble(1, 1_000);
    }
}
