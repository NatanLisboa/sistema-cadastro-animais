package br.com.animais.sistemacadastroanimais.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.repository.AnimalRepository;

@RestController
@RequestMapping("/animais")
public class AnimalController {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@GetMapping
	@RequestMapping("")	
	public List<AnimalDto> listarAnimaisCadastrados(){
		
		List<Animal> animais = new ArrayList<>();
		
		animais = animalRepository.findAll();
		
		return AnimalDto.converter(animais);
		
	}

	
	@GetMapping
	@RequestMapping("/filtrar-por-nome")	
	public List<AnimalDto> listarAnimaisCadastradosPorNome(String nomeAnimal){
		
		List<Animal> animais = new ArrayList<>();
		
		animais = animalRepository.findByNome(nomeAnimal);
		
		return AnimalDto.converter(animais);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDto> buscarAnimalPorId(@PathVariable long id) {
		
		Optional<Animal> animal = animalRepository.findById(id);
		
		if (animal.isPresent()) {
			return ResponseEntity.ok(new AnimalDto(animal.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public ResponseEntity<AnimalDto> cadastrarAnimal(@RequestBody @Valid AnimalForm form, UriComponentsBuilder uriBuilder) {
		Animal animal = form.converterParaAnimal();
		animalRepository.save(animal);
		
		URI uri = uriBuilder.path("/animais/cadastrar/{id}").buildAndExpand(animal.getId()).toUri();
		return ResponseEntity.created(uri).body(new AnimalDto(animal));
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<AnimalDto> atualizarAnimal(@PathVariable Long id, @RequestBody @Valid AtualizacaoAnimalForm form) {
		
		Optional<Animal> animalParaBusca = animalRepository.findById(id); 
		
		if (animalParaBusca.isPresent()) {
			Animal animal = form.atualizarAnimal(id, animalRepository);
			return ResponseEntity.ok(new AnimalDto(animal));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletarAnimal(@PathVariable Long id) {
		
		Optional<Animal> animalParaBusca = animalRepository.findById(id); 
		
		if (animalParaBusca.isPresent()) {
			animalRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
		
	}
	
}
