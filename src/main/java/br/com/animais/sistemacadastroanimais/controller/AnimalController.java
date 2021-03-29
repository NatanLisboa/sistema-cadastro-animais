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

/* Classe que será responsável por realizar todas as requisições ao banco de dados */
@RestController
@RequestMapping("/animais") // URI base para todos os métodos da classe
public class AnimalController {
	
	@Autowired
	private AnimalRepository animalRepository; // Objeto responsável por realizar todas as operações que envolvem o banco de dados
	
	/* Método para buscar os animais cadastrados no banco de dados e listá-los */
	@GetMapping // Tipo da requisição e URI da página (nesse caso, será "/animais" para listar todos ou /animais?nome={nome} para listar animais pelo seu nome)
	public List<AnimalDto> listarTodosOsAnimaisCadastradosOuListarPeloNome(String nome){
		
		List<Animal> animais = new ArrayList<>();
		
		if (nome == null) {
			animais = animalRepository.findAll();
		} else {
			animais = animalRepository.findByNome(nome);
		}
		
		return AnimalDto.converter(animais); // Função que converte um objeto do tipo Animal para AnimalDto, a fim de se adequar ao tipo de retorno do método em questão
		
	}

	/* Método para buscar os animais cadastrados no banco de dados e listá-los, tendo como parâmetro o id do animal procurado */
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDto> buscarAnimalPorId(@PathVariable long id) {
		
		Optional<Animal> animal = animalRepository.findById(id);
		
		if (animal.isPresent()) {
			return ResponseEntity.ok(new AnimalDto(animal.get())); //Retorna o código HTTP 200 e o animal procurado, caso ele seja encontrado no banco de dados.
		}
		
		return ResponseEntity.notFound().build(); //Retorna o código HTTP 404, caso ele não seja encontrado no banco de dados.
	}	
	
	/* Método para cadastrar animais no banco de dados */
	@PostMapping
	public ResponseEntity<AnimalDto> cadastrarAnimal(@RequestBody @Valid AnimalForm form, UriComponentsBuilder uriBuilder) {
		
		Animal animal = form.converterParaAnimal(); // Método que converte um objeto do tipo AnimalForm para Animal
		animalRepository.save(animal); // Grava o animal no banco de dados
		
		URI uri = uriBuilder.path("/animais/{id}").buildAndExpand(animal.getId()).toUri(); // Variável que contém a URI criada para ser exibida após o cadastramento com êxito de um novo animal, representando a URI onde se encontra o novo animal
		return ResponseEntity.created(uri).body(new AnimalDto(animal)); // Retorna o código HTTP 201 e os dados do animal criado
		
	}
	
	/* Método para atualizar os dados de animais do banco de dados */
	@PutMapping("/{id}")
	@Transactional 
	public ResponseEntity<AnimalDto> atualizarAnimal(@PathVariable Long id, @RequestBody @Valid AtualizacaoAnimalForm form) {
		
		Optional<Animal> animalParaBusca = animalRepository.findById(id); // Busca o animal desejado para atualização por id
		
		if (animalParaBusca.isPresent()) {
			Animal animal = form.atualizarAnimal(id, animalRepository); // Atualiza o animal com o id passado como parâmetro
			return ResponseEntity.ok(new AnimalDto(animal)); // Retorna o código HTTP 200 e os dados do animal modificado, caso tudo seja concluído com sucesso.
		}
		
		return ResponseEntity.notFound().build(); // Retorna o código HTTP 404 caso o animal não seja encontrado no banco de dados
		
	}
	
	/* Método para deletar animais do banco de dados */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarAnimal(@PathVariable Long id) {
		
		Optional<Animal> animalParaBusca = animalRepository.findById(id); 
		
		if (animalParaBusca.isPresent()) {
			animalRepository.deleteById(id); // Deleta o animal com o id passado como parâmetro
			return ResponseEntity.ok().build(); // Retorna o código HTTP 200, caso o animal seja deletado com sucesso.
		}

		return ResponseEntity.notFound().build(); // Retorna o código HTTP 404 caso o animal não seja encontrado no banco de dados
		
	}
	
}