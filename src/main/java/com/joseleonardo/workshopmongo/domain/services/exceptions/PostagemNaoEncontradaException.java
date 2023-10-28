package com.joseleonardo.workshopmongo.domain.services.exceptions;

public class PostagemNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public PostagemNaoEncontradaException(String id) {
		super(String.format("Não existe um cadastro de postagem com código %s", id));
	}
	
}
