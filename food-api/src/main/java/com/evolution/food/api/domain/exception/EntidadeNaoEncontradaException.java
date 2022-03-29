package com.evolution.food.api.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}