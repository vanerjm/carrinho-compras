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

import br.com.vaner.carrinhocompras.entities.Item;
import br.com.vaner.carrinhocompras.repositories.ItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/items")
	public List<Item> getUsers() {
		return (List<Item>) itemRepository.findAll();
	}

	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getUserById(@PathVariable(value = "id") String itemId) throws Exception {
		Item targetUser = itemRepository.findById(itemId)
				.orElseThrow(() -> new Exception("Item not found for this id :: " + itemId));
		
		return ResponseEntity.ok(targetUser);
	}

	@PostMapping("/items")
	public void addUser(@RequestBody Item item) {
		itemRepository.save(item);
	}

	@PutMapping("/items/{id}")
	public ResponseEntity<Item> editUser(@PathVariable(value = "id") String itemId, @RequestBody Item itemInfo) throws Exception {

		Item targetUser = itemRepository.findById(itemInfo.getId())
				.orElseThrow(() -> new Exception("Item not found for this id :: " + itemId));
		
		targetUser.setName(itemInfo.getName());
		targetUser.setValue(itemInfo.getValue());
		final Item updatedUser = itemRepository.save(targetUser);

		return ResponseEntity.ok(updatedUser);
		
	}

	@DeleteMapping("/items/{id}")
	public Boolean deleteUser(@PathVariable(value = "id") String itemId) throws Exception {
		Item targetUser = itemRepository.findById(itemId)
				.orElseThrow(() -> new Exception("Item not found for this id :: " + itemId));
		
		itemRepository.deleteById(targetUser.getId());
		
		return true;
	}
}
