package br.com.animais.sistemacadastroanimais.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.animais.sistemacadastroanimais.model.Animal;

@SpringBootTest
public class AnimalRepositoryTest {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Test
	public void devolverCaracteristicasAnimalExistenteBuscandoPeloNome() {
		
		String nomeAnimal = "Max";
		List<Animal> listaAnimais = animalRepository.findByNome(nomeAnimal);
		assertNotNull(nomeAnimal);
		for (Animal animal : listaAnimais) {
			assertEquals(nomeAnimal, animal.getNome());
		}
		
	}
	
	@Test
	public void devolverListaVaziaParaAnimalNaoEncontradoPeloNome() {
		
		String nomeAnimal = "Não existe um animal com esse nome";
		List<Animal> listaAnimais = animalRepository.findByNome(nomeAnimal);
		assertEquals(0, listaAnimais.size());
		
	}

}
