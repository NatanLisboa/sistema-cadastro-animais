package br.com.animais.sistemacadastroanimais.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.animais.sistemacadastroanimais.model.Animal;

/* Classe para testar os retornos do método presente na classe de produção AnimalRepository */
@SpringBootTest
public class AnimalRepositoryTest {
	
	@Autowired
	private AnimalRepository animalRepository; /* Objeto responsável por realizar todas as operações que envolvem o banco de dados */
	
	/* Método para testar se a aplicação está devolvendo uma lista com todas as características de um animal que foi buscado pelo seu nome */
	@Test
	public void devolverCaracteristicasAnimalExistenteBuscandoPeloNome() {
		
		String nomeAnimal = "Max";
		List<Animal> listaAnimais = animalRepository.findByNome(nomeAnimal);
		assertNotNull(nomeAnimal);
		for (Animal animal : listaAnimais) {
			assertEquals(nomeAnimal, animal.getNome());
		}
		
	}

	/* Método para testar se a aplicação está devolvendo uma lista vazia para uma busca por um nome de um animal que não retornou nenhuma ocorrência */
	@Test
	public void devolverListaVaziaParaAnimalNaoEncontradoPeloNome() {
		
		String nomeAnimal = "Não existe um animal com esse nome";
		List<Animal> listaAnimais = animalRepository.findByNome(nomeAnimal);
		assertEquals(0, listaAnimais.size());
		
	}

}
