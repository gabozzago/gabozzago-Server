package com.wwg.gabozzago;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@SpringBootApplication
public class GabozzagoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GabozzagoApplication.class, args);
    }

}
