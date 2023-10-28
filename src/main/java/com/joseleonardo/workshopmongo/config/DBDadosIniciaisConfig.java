package com.joseleonardo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joseleonardo.workshopmongo.api.dto.AutorDTO;
import com.joseleonardo.workshopmongo.domain.entities.Postagem;
import com.joseleonardo.workshopmongo.domain.entities.Usuario;
import com.joseleonardo.workshopmongo.domain.repositories.PostagemRepository;
import com.joseleonardo.workshopmongo.domain.repositories.UsuarioRepository;

@Configuration
public class DBDadosIniciaisConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		usuarioRepository.deleteAll();
		postagemRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Postagem postagem1 = new Postagem(null, format.parse("21/03/2018"), 
				"Partiu viagem", "Vou viaja para São Paulo. Abraços!", new AutorDTO(maria));
		Postagem postagem2 = new Postagem(null, format.parse("21/03/2018"), 
				"Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		postagemRepository.saveAll(Arrays.asList(postagem1, postagem2));
	}

}
