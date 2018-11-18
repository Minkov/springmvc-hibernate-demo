package com.minkov.springbootdemo.seeders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedersConfiguration {
    @Bean
    @Qualifier("seed-file-name")
    String seedFileName() {
        return "seed.json";
    }
}
