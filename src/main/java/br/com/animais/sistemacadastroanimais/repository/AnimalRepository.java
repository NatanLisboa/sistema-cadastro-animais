package br.com.animais.sistemacadastroanimais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.animais.sistemacadastroanimais.model.Animal;

/* Interface que estende a classe que traz os métodos da JPA */
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByNome(String nome);
	
}
