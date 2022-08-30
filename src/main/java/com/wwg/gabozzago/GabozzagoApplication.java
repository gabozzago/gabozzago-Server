package com.wwg.gabozzago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
@ConfigurationPropertiesScan
@SpringBootApplication
public class GabozzagoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GabozzagoApplication.class, args);
    }

}
