package br.com.vaner.carrinhocompras.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vaner.carrinhocompras.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{} 