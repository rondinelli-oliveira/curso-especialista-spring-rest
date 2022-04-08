package com.evolution.food.api.domain.repository;

import com.evolution.food.api.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNomeContaining(String nome);

    Optional<Cozinha> findByNome(String nome);

    boolean existsByNome(String nome);

}
