package com.example.futticoappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.futticoappserver.Repositories"})
public class FutTicoAppServerApplication {

    public static void main(String[] args) {
       
        SpringApplication.run(FutTicoAppServerApplication.class, args);


    }

}
