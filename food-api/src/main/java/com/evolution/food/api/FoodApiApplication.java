package com.evolution.food.api;

import com.evolution.food.api.infrastruture.repository.CustomJpaRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class FoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApiApplication.class, args);
        log.info("O aplicativo Evolution Food foi iniciado com sucesso.");
    }

}
