package br.com.animais.sistemacadastroanimais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* Classe para execução da aplicação */
@SpringBootApplication
@EnableSwagger2
public class SistemacadastroanimaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemacadastroanimaisApplication.class, args);
	}

}
