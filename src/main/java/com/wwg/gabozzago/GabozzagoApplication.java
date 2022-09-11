package com.wwg.gabozzago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.wwg.gabozzago"})
public class GabozzagoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GabozzagoApplication.class, args);
    }

}
