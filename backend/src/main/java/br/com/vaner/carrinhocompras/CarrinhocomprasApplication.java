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
}
