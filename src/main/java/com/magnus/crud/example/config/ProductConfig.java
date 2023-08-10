package com.magnus.crud.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProductConfig {

    @Profile("local")
    @Bean
    public String localBean(){

        System.out.println("Hello local");

        return "local";
    }
}
