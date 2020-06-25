package com.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.food.domain.model.Restaurante;
import com.food.domain.repository.RestauranteRepository;

public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.salvar(restaurante);
	}

}
