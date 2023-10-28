package com.joseleonardo.workshopmongo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.workshopmongo.controllers.util.URL;
import com.joseleonardo.workshopmongo.domain.entities.Postagem;
import com.joseleonardo.workshopmongo.domain.services.PostagemService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Postagem> buscar(@PathVariable String id) {
		Postagem postagem = postagemService.buscarPorId(id);
		
		return ResponseEntity.ok().body(postagem);
	}
	
	@GetMapping(value = "/pesquisartitulo")
	public ResponseEntity<List<Postagem>> buscarPorTitulo(
			@RequestParam(value = "titulo", defaultValue = "") String titulo) {
		titulo = URL.decodificarParametro(titulo);
		
		List<Postagem> postagens = postagemService.buscarPorTitulo(titulo);
		
		return ResponseEntity.ok().body(postagens);
	}
	
	@GetMapping(value = "/pesquisaCompleta")
	public ResponseEntity<List<Postagem>> pesquisaCompleta(
			@RequestParam(value = "texto", defaultValue = "") String texto,
			@RequestParam(value = "dataMinima", defaultValue = "") String dataMinima,
			@RequestParam(value = "dataMaxima", defaultValue = "") String dataMaxima) {
		texto = URL.decodificarParametro(texto);
		Date min = URL.converterData(dataMinima, new Date(0L));
		Date max = URL.converterData(dataMaxima, new Date());
		
		List<Postagem> postagens = postagemService.pesquisaCompleta(texto, min, max);
		
		return ResponseEntity.ok().body(postagens);
	}
	
}
