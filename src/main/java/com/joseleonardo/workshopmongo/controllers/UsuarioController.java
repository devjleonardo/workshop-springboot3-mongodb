package com.joseleonardo.workshopmongo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joseleonardo.workshopmongo.domain.dto.UsuarioDTO;
import com.joseleonardo.workshopmongo.domain.entities.Postagem;
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
	
	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.converterParaDTO(usuarioDTO);
		usuario = usuarioService.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuario.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(usuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		usuarioService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.converterParaDTO(usuarioDTO);
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/postagens")
	public ResponseEntity<List<Postagem>> buscarPostagens(@PathVariable String id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok().body(usuario.getPostagens());
	}
	
}
