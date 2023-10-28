package com.joseleonardo.workshopmongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joseleonardo.workshopmongo.domain.dto.UsuarioDTO;
import com.joseleonardo.workshopmongo.domain.entities.Usuario;
import com.joseleonardo.workshopmongo.domain.repositories.UsuarioRepository;
import com.joseleonardo.workshopmongo.domain.services.exceptions.BancoDeDadosException;
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
	
	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.insert(usuario);
	}
	
	public void deletar(String id) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

		if (usuarioExistente.isPresent()) {
			try {
				usuarioRepository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new BancoDeDadosException(e.getMessage());
			}
		} else {
			throw new UsuarioNaoEncontradoException(id);
		}
	}
	
	public Usuario atualizar(Usuario usuarioAtualizado) {
		Usuario usuarioAtual = buscarPorId(usuarioAtualizado.getId());
			
		atualizarDados(usuarioAtual, usuarioAtualizado);
			
		return usuarioRepository.save(usuarioAtualizado);
	}
	
	private void atualizarDados(Usuario usuarioAtual, Usuario usuarioAtualizado) {
		usuarioAtual.setNome(usuarioAtualizado.getNome());
		usuarioAtual.setEmail(usuarioAtualizado.getEmail());
	}

	public Usuario converterParaDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
	
}
