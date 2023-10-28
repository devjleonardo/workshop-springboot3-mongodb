package com.joseleonardo.workshopmongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.workshopmongo.domain.entities.Usuario;
import com.joseleonardo.workshopmongo.domain.repositories.UsuarioRepository;
import com.joseleonardo.workshopmongo.domain.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario.orElseThrow(() -> new UsuarioNaoEncontradoException(id));
	}
	
}
