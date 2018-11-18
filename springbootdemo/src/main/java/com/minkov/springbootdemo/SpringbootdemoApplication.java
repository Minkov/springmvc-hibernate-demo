package com.minkov.springbootdemo;

import com.minkov.springbootdemo.seeders.Seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class SpringbootdemoApplication {
    @Autowired
    public Seeder seeder;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        seeder.seed();
    }
}
