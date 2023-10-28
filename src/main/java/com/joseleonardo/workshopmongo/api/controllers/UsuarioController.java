package com.joseleonardo.workshopmongo.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.workshopmongo.api.dto.UsuarioDTO;
import com.joseleonardo.workshopmongo.domain.entities.Usuario;
import com.joseleonardo.workshopmongo.domain.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar() {
		List<Usuario> todosUsuarios = usuarioService.listarTodos();
		
		List<UsuarioDTO> usuariosDTO = todosUsuarios.stream()
				.map(usuario -> new UsuarioDTO(usuario))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuariosDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable String id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
	
}
