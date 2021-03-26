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

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void devolver200NaBuscaPorIdDeUmAnimalExistenteNoBanco() throws Exception {
		
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
	
	@Test
	void devolver404NaBuscaDeUmAnimalInexistenteNoBanco() throws Exception {
			
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

	
	@Test
	void devolver201NaCriacaoDeUmAnimalNoBanco() throws Exception {
		URI uri = new URI("/animais/cadastrar");
		String json = "{"
						+ "\"nome\": \"Arthus\","
						+ "\"tipo\": \"Cachorro\","
						+ "\"dataNascimento\": \"1994-03-10\","
						+ "\"sexo\": \"M\""
					+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
		
	}
	
	@Test
	void devolver200NaAtualizacaoComExitoDeUmAnimalNoBanco() throws Exception {
		URI uri = new URI("/animais/atualizar/2");
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
	
	@Test
	void devolver404NaTentativaDeAtualizacaoDeUmAnimalInexistenteNoBanco() throws Exception {
		URI uri = new URI("/animais/atualizar/999");
		String json = "{"
						+ "\"nome\": \"Pintado\","
						+ "\"tipo\": \"Onça\","
						+ "\"dataNascimento\": \"2001-03-14\","
						+ "\"sexo\": \"M\""
					+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
			
	}
	
	@Test
	void devolver200NaDelecaoComExitoDeUmAnimalExistenteNoBanco() throws Exception {
		
		URI uri = new URI("/animais/deletar/3");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON
				))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	void devolver404NaTentativaDeDelecaoDeUmAnimalInexistenteNoBanco() throws Exception {
		
		URI uri = new URI("/animais/deletar/999");
		
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
