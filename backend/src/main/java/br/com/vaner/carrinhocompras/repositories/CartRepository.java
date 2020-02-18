package br.com.vaner.carrinhocompras.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vaner.carrinhocompras.entities.Cart;

public interface CartRepository extends MongoRepository<Cart, String>{
	
	public Iterable<Cart> findAllByOrderByTotalDesc();
} 