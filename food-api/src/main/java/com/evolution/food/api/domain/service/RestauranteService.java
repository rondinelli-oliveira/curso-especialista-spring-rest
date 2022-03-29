package com.evolution.food.api.domain.service;

import com.evolution.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.evolution.food.api.domain.model.Cozinha;
import com.evolution.food.api.domain.model.Restaurante;
import com.evolution.food.api.domain.repository.CozinhaRepository;
import com.evolution.food.api.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long id = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscar(id);

        if (cozinha == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", id));
        }

        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }
}
