package br.com.vaner.carrinhocompras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vaner.carrinhocompras.entities.Cart;
import br.com.vaner.carrinhocompras.repositories.CartRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("/carts")
	public List<Cart> getCarts() {
		return (List<Cart>) cartRepository.findAll();
	}

	@GetMapping("/carts/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable(value = "id") Long cartId) throws Exception {
		Cart targetCart = cartRepository.findById(cartId)
				.orElseThrow(() -> new Exception("Cart not found for this id :: " + cartId));
		
		return ResponseEntity.ok(targetCart);
	}

	@PostMapping("/carts")
	public void addCart(@RequestBody Cart cart) {
		cartRepository.save(cart);
	}

	@PutMapping("/carts/{id}")
	public ResponseEntity<Cart> editCart(@PathVariable(value = "id") Long cartId, @RequestBody Cart cartInfo) throws Exception {

		Cart targetCart = cartRepository.findById(cartInfo.getId())
				.orElseThrow(() -> new Exception("Cart not found for this id :: " + cartId));
		
		targetCart.setUser(cartInfo.getUser());
		targetCart.setItems(cartInfo.getItems());
		final Cart updatedCart = cartRepository.save(targetCart);

		return ResponseEntity.ok(updatedCart);
		
	}

	@DeleteMapping("/carts/{id}")
	public Boolean deleteCart(@PathVariable(value = "id") Long cartId) throws Exception {
		Cart targetCart = cartRepository.findById(cartId)
				.orElseThrow(() -> new Exception("Cart not found for this id :: " + cartId));
		
		cartRepository.deleteById(targetCart.getId());
		
		return true;
	}
}
