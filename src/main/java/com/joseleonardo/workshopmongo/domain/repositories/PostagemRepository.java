package com.joseleonardo.workshopmongo.domain.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joseleonardo.workshopmongo.domain.entities.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

}
