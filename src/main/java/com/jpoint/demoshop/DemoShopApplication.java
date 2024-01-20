package com.jpoint.demoshop;

import com.jpoint.demoshop.service.PopulationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoShopApplication implements CommandLineRunner {

    private final PopulationService populationService;

    public DemoShopApplication(PopulationService populationService) {
        this.populationService = populationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoShopApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        long l = System.currentTimeMillis();
        populationService.populateTables();
        System.out.printf("Executed in %d second(s) \n", (System.currentTimeMillis() - l) / 1000);
        System.out.println("OK");
    }
}
