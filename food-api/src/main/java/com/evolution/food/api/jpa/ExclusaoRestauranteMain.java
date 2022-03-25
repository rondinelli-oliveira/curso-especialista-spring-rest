package com.evolution.food.api.jpa;

import com.evolution.food.api.FoodApiApplication;
import com.evolution.food.api.domain.model.Cozinha;
import com.evolution.food.api.domain.model.Restaurante;
import com.evolution.food.api.domain.repository.CozinhaRepository;
import com.evolution.food.api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);

        restauranteRepository.remover(restaurante);
    }
}