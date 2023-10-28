package com.joseleonardo.workshopmongo.domain.services.exceptions;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException(String id) {
		super(String.format("Não existe um cadastro de usuário com código %s", id));
	}
	
}
