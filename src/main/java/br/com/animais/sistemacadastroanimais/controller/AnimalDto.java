package br.com.animais.sistemacadastroanimais.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;

/* Classe que define a forma de como os animais serão exibidos na tela do usuário quando requisitados */
public class AnimalDto {
	
	/* Atributos que serão exibidos */
	private long id;
	private String nome;
	private String tipo;
	private Date dataNascimento;
	private SexoAnimal sexo;
	
	/* Construtor que recebe um objeto do tipo Animal e inicializa os valores desejados para exibição */
	public AnimalDto(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.tipo = animal.getTipo();
		this.dataNascimento = animal.getDataNascimento();
		this.sexo = animal.getSexo();
	}
	
	/* Métodos GETTERS (os métodos SETTERS não serão necessários nesse caso, uma vez que não haverá manipulação dos dados) */
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public SexoAnimal getSexo() {
		return sexo;
	}
	
	/* Método que converte uma lista de objetos do tipo Animal para AnimalDto, a fim de que este último seja exibido para o usuário*/
	public static List<AnimalDto> converter(List<Animal> animais) {
		return animais.stream().map(AnimalDto::new).collect(Collectors.toList()); // Para cada objeto do tipo Animal existente na lista, um novo objeto do tipo AnimalDto é instanciado para receber os campos do objeto Animal. No final, tudo é colocado em uma lista
	}
		
}
