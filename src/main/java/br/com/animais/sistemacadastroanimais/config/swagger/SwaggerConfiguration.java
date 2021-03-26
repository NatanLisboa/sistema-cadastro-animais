package br.com.animais.sistemacadastroanimais.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/* Classe de configuração para formulação automática da documentação Swagger */
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket animaisApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.animais.sistemacadastroanimais")) // Caminho do pacote que será analisado pelo Swagger
				.paths(PathSelectors.ant("/**"))
				.build();
	}
	
}
