package br.com.animais.sistemacadastroanimais.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/* Classe para testar a eficácia do controller do projeto, verificando se as páginas estão retornando o código HTTP correto conforme as requisições */
@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTest {
	
	@Autowired
	private MockMvc mockMvc; // Objeto para realizar as requisições HTTP
	
	/* Método que testa se o código HTTP 200 está sendo devolvido na URI para listagem de todos os animais presentes no banco de dados */
	@Test
	void devolver200NaListagemDeTodosOsAnimaisPresentesNoBancoDeDados() throws Exception {
		
		URI uri = new URI("/animais"); // URI para acesso de uma rota do sistema
		
		// Criação da requisição e teste para verificar se ela está retornando o código HTTP esperado
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri) // Tipo da requisição que será feita
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	/* Método que testa se o código HTTP 200 está sendo devolvido na filtragem de um animal existente pelo seu nome */
	@Test
	void devolver200NaFiltragemDeAnimaisExistentesPeloNome() throws Exception {
		
		URI uri = new URI("/animais?nome=Max");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	/* Método que testa se o código HTTP 200 está sendo devolvido na filtragem de um animal inexistente no banco de dados, buscando pelo seu nome */
	@Test
	void devolver200NaFiltragemDeAnimaisInexistentesPeloNome() throws Exception {
		
		URI uri = new URI("/animais?nome=Spyke");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}

	
	/* Método que testa se o código HTTP 200 está sendo devolvido na busca de um animal existente no banco de dados (por id) */
	@Test
	void devolver200NaBuscaPorIdDeUmAnimalExistenteNoBancoDeDados() throws Exception {
		
		URI uri = new URI("/animais/1");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	/* Método que testa se o código HTTP 404 está sendo devolvido na busca de um animal inexistente no banco de dados (por id) */
	@Test
	void devolver404NaBuscaDeUmAnimalInexistenteNoBancoDeDados() throws Exception {
			
		URI uri = new URI("/animais/999");

		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}

	/* Método que testa se o código HTTP 201 está sendo retornado na criação com êxito de um animal no banco de dados */	
	@Test
	void devolver201NaCriacaoDeUmAnimalNoBancoDeDados() throws Exception {
		URI uri = new URI("/animais");
		String json = "{"
						+ "\"nome\": \"Arthus\","
						+ "\"tipo\": \"Cachorro\","
						+ "\"dataNascimento\": \"1994-03-10\","
						+ "\"sexo\": \"M\""
					+ "}";  // Variável que simula o arquivo JSON necessário para a requisição do tipo POST. 
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
	}

	/* Método que testa se o código HTTP 200 está sendo retornado na atualização com êxito de um animal no banco de dados */	
	@Test
	void devolver200NaAtualizacaoComExitoDeUmAnimalNoBancoDeDados() throws Exception {
		URI uri = new URI("/animais/2");
		String json = "{"
						+ "\"nome\": \"Frida\","
						+ "\"tipo\": \"Cachorro\","
						+ "\"dataNascimento\": \"1994-03-10\","
						+ "\"sexo\": \"F\""
					+ "}";
		
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
		
		
	}

	/* Método que testa se o código HTTP 404 está sendo retornado na tentativa de atualização de um animal inexistente no banco de dados */	
	@Test
	void devolver404NaTentativaDeAtualizacaoDeUmAnimalInexistenteNoBancoDeDados() throws Exception {
		URI uri = new URI("/animais/999");
		String json = "{"
						+ "\"nome\": \"Pintado\","
						+ "\"tipo\": \"Onça\","
						+ "\"dataNascimento\": \"2001-03-14\","
						+ "\"sexo\": \"M\""
					+ "}"; // Variável que simula o arquivo JSON necessário para a requisição do tipo PUT. 
		
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
			
	}
	
	/* Método que testa se o código HTTP 200 está sendo retornado na deleção com êxito de um animal do banco de dados */		
	@Test
	void devolver200NaDelecaoComExitoDeUmAnimalExistenteNoBancoDeDados() throws Exception {
		
		URI uri = new URI("/animais/3");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	/* Método que testa se o código HTTP 404 está sendo retornado na tentativa de deleção de um animal inexistente no banco de dados */	
	@Test
	void devolver404NaTentativaDeDelecaoDeUmAnimalInexistenteNoBancoDeDados() throws Exception {
		
		URI uri = new URI("/animais/999");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
}
