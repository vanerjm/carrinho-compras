package br.com.vaner.carrinhocompras.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.vaner.carrinhocompras.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{
	
	@Query("from Cart where user_id=:userId")
	public Iterable<Cart> findByUserId(@Param("userId") Long userId);
} 