package br.com.animais.sistemacadastroanimais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.animais.sistemacadastroanimais.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByNome(String nome);
	
}
