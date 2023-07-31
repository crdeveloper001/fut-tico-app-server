package com.example.futticoappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.futticoappserver.repositories"})
@ComponentScan(basePackages = {"com.example.*"})
public class FutTicoAppServerApplication {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        SpringApplication.run(FutTicoAppServerApplication.class, args);


    }

}
