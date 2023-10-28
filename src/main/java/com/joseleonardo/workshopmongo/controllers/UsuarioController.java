package com.joseleonardo.workshopmongo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.workshopmongo.domain.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		Usuario maria = new Usuario("1", "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario("1", "Maria Green", "alex@gmail.com");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(usuarios);
	}
	
}
