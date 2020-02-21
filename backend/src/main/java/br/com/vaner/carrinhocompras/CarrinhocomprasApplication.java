package br.com.vaner.carrinhocompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CarrinhocomprasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhocomprasApplication.class, args);
	}	

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CarrinhocomprasApplication.class);
    }
}
	