package br.com.vaner.carrinhocompras;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.vaner.carrinhocompras.entities.Item;
import br.com.vaner.carrinhocompras.entities.User;
import br.com.vaner.carrinhocompras.repositories.ItemRepository;
import br.com.vaner.carrinhocompras.repositories.UserRepository;

@SpringBootApplication
public class CarrinhocomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhocomprasApplication.class, args);
	}

	@Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
	
	@Bean
    CommandLineRunner initItems(ItemRepository itemRepository) {
		
        return args -> {
            Stream.of("Sabonete", "Shampoo", "Papel Higienico", "Creme Dental", "Escova de Dentes").forEach(name -> {
                Item item = new Item(name, new Random().nextFloat()*100F);
                itemRepository.save(item);
            });
            itemRepository.findAll().forEach(System.out::println);
        };
    }		
}
