package com.joseleonardo.workshopmongo.domain.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joseleonardo.workshopmongo.domain.entities.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Postagem> buscarPorTitulo(String titulo);
	
	List<Postagem> findByTituloContainingIgnoreCase(String titulo);

	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , "
			+ "{ $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'corpo': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Postagem> pesquisaCompleta(String texto, Date dataMinima, Date dataMaxima);
	
}
