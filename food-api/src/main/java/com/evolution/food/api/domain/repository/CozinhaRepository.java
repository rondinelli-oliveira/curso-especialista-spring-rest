package com.evolution.food.api.domain.repository;

import com.evolution.food.api.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNome(String nome);

    Optional<Cozinha> findByNome(String nome);

}
