package br.com.animais.sistemacadastroanimais.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public List<AnimalDto> listarAnimaisCadastradosPorNome(String nomeAnimal){
		
		List<Animal> animais = new ArrayList<>();
		
		if (nomeAnimal == null) {
			animais = animalRepository.findAll();
		} else {
			animais = animalRepository.findByNome(nomeAnimal);
		}
		
		return AnimalDto.converter(animais);
		
	}
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public ResponseEntity<AnimalDto> cadastrarAnimal(@RequestBody AnimalForm form, UriComponentsBuilder uriBuilder) {
		Animal animal = form.converterParaAnimal();
		animalRepository.save(animal);
		
		URI uri = uriBuilder.path("/animais/cadastrar/{id}").buildAndExpand(animal.getId()).toUri();
		return ResponseEntity.created(uri).body(new AnimalDto(animal));
	}
	
	
}
