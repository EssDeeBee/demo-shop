package com.jpoint.demoshop;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricAttribute;
import com.codahale.metrics.MetricRegistry;
import com.jpoint.demoshop.service.PopulationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import java.util.concurrent.TimeUnit;

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

        MetricRegistry metricRegistry = new MetricRegistry();
        var timer = metricRegistry.timer("main");

        var iterationCount = 10;
        for (int i = 0; i < iterationCount; i++) {
            try (var ignored = timer.time()) {
                populationService.populateTables();
            }
        }

        try (var reporter = makeReporter(metricRegistry)) {
            reporter.report();
        }

        System.out.printf("Executed in %d second(s) \n", (System.currentTimeMillis() - l) / 1000);
        System.out.println("OK");
    }

    private ConsoleReporter makeReporter(MetricRegistry metricRegistry) {
        return ConsoleReporter.forRegistry(metricRegistry)
                .convertDurationsTo(TimeUnit.SECONDS)
                .disabledMetricAttributes(Set.of(
                        MetricAttribute.M1_RATE,
                        MetricAttribute.M5_RATE,
                        MetricAttribute.M15_RATE,
                        MetricAttribute.P75,
                        MetricAttribute.P95,
                        MetricAttribute.P98,
                        MetricAttribute.P99,
                        MetricAttribute.P999
                ))
                .build();
    }
}
