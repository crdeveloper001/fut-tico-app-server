package com.example.futticoappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

@SpringBootApplication
@ServletComponentScan
@EnableJpaRepositories(basePackages = {"com.example.futticoappserver.Repositories"})
@EntityScan(basePackages = {"com.example.futticoappserver.Models"})
public class FutTicoAppServerApplication {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        SpringApplication.run(FutTicoAppServerApplication.class, args);


    }

}
