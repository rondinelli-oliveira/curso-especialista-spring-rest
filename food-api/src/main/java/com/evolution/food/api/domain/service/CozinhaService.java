package com.evolution.food.api.domain.service;

import com.evolution.food.api.domain.exception.EntidadeEmUsoException;
import com.evolution.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.evolution.food.api.domain.model.Cozinha;
import com.evolution.food.api.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);
    }

    public void excluir(Long id) {
        try {
            cozinhaRepository.remover(id);
        }catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com o código: %d.", id));
        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser excluída, pois está em uso.", id));
        }
    }
}
