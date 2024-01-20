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
        populationService.populateTables();
        System.out.println("OK");
    }
}
