package com.joseleonardo.workshopmongo.domain.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joseleonardo.workshopmongo.domain.entities.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

	@Query(" { 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Postagem> pesquisarPorTitulo(String titulo);
	
	List<Postagem> findByTituloContainingIgnoreCase(String titulo);
	
}
