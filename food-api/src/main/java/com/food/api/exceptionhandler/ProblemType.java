package com.food.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://food.com.br" + path;
		this.title = title;
	}
	
}