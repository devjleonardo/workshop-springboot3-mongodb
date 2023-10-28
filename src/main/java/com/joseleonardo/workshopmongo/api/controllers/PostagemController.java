package com.joseleonardo.workshopmongo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
