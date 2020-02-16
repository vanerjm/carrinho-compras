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

import br.com.vaner.carrinhocompras.entities.User;
import br.com.vaner.carrinhocompras.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws Exception {
		User targetUser = userRepository.findById(userId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + userId));
		
		return ResponseEntity.ok(targetUser);
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> editUser(@PathVariable(value = "id") Long userId, @RequestBody User userInfo) throws Exception {

		User targetUser = userRepository.findById(userInfo.getId())
				.orElseThrow(() -> new Exception("User not found for this id :: " + userId));

		targetUser.setEmail(userInfo.getEmail());
		targetUser.setName(userInfo.getName());
		final User updatedUser = userRepository.save(targetUser);

		return ResponseEntity.ok(updatedUser);
		
	}

	@DeleteMapping("/users/{id}")
	public Boolean deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		User targetUser = userRepository.findById(userId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + userId));
		
		userRepository.deleteById(targetUser.getId());
		
		return true;
	}
}