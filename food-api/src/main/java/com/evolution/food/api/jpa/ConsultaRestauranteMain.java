package com.evolution.food.api.jpa;

import com.evolution.food.api.FoodApiApplication;
import com.evolution.food.api.domain.model.Cozinha;
import com.evolution.food.api.domain.model.Restaurante;
import com.evolution.food.api.domain.repository.CozinhaRepository;
import com.evolution.food.api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> todosRestaurantes = restauranteRepository.listar();

        for (Restaurante restaurante : todosRestaurantes) {
            System.out.println(restaurante.getNome());
        }
    }
}
