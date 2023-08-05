package com.example.futticoappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.futticoappserver.repositories"})
@ComponentScan(basePackages = {"com.example.*"})
public class FutTicoAppServerApplication {

    public static void main(String[] args) {
       
        SpringApplication.run(FutTicoAppServerApplication.class, args);


    }

}
