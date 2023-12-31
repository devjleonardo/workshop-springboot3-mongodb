package com.joseleonardo.workshopmongo.domain.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.workshopmongo.domain.entities.Postagem;
import com.joseleonardo.workshopmongo.domain.repositories.PostagemRepository;
import com.joseleonardo.workshopmongo.domain.services.exceptions.PostagemNaoEncontradaException;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;
	
	public Postagem buscarPorId(String id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		
		return postagem.orElseThrow(() -> new PostagemNaoEncontradaException(id));
	}
	
	public List<Postagem> buscarPorTitulo(String titulo) {
		return postagemRepository.buscarPorTitulo(titulo);
	}
	
	public List<Postagem> pesquisaCompleta(String texto, Date dataMinima, Date dataMaxima) {
		dataMaxima = new Date(dataMaxima.getTime() + 24 * 60 * 60 * 1000);
		
		return postagemRepository.pesquisaCompleta(texto, dataMinima, dataMaxima);
	}
	
}
