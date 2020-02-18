package br.com.vaner.carrinhocompras.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vaner.carrinhocompras.entities.Item;

public interface ItemRepository extends MongoRepository<Item, String>{} 