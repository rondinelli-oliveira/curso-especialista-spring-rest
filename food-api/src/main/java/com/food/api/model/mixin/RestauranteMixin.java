package com.food.api.model.mixin;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.food.domain.model.Cozinha;
import com.food.domain.model.Endereco;
import com.food.domain.model.FormaPagamento;
import com.food.domain.model.Produto;

public abstract class RestauranteMixin {

	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	private Cozinha cozinha;
	
	@JsonIgnore
	private Endereco endereco;
	
	@JsonIgnore
	private OffsetDateTime dataCadastro;
	
	@JsonIgnore
	private OffsetDateTime dataAtualizacao;
	
	@JsonIgnore
	private List<FormaPagamento> formasPagamento;
	
	@JsonIgnore
	private List<Produto> produtos;
	
}