package br.com.vaner.carrinhocompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class CarrinhocomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhocomprasApplication.class, args);
	}
}
	