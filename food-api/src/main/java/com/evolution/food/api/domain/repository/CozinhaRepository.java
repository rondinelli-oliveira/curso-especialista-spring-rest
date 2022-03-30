package com.evolution.food.api.domain.repository;

import com.evolution.food.api.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

//    List<Cozinha> consultarPorNome(String nome);

}
