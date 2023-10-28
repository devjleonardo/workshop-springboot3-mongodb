package com.joseleonardo.workshopmongo.domain.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joseleonardo.workshopmongo.domain.entities.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

	List<Postagem> findByTituloContainingIgnoreCase(String titulo);
	
}
