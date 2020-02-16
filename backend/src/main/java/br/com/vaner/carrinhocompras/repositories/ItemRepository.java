package br.com.vaner.carrinhocompras.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.vaner.carrinhocompras.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{} 