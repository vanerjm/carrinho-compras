package br.com.vaner.carrinhocompras.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vaner.carrinhocompras.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{} 