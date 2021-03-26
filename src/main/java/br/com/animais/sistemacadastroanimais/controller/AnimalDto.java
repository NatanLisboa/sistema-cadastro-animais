package br.com.animais.sistemacadastroanimais.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;

public class AnimalDto {
	
	private long id;
	private String nome;
	private String tipo;
	private Date dataNascimento;
	private SexoAnimal sexo;
	
	public AnimalDto(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.tipo = animal.getTipo();
		this.dataNascimento = animal.getDataNascimento();
		this.sexo = animal.getSexo();
	}
	
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

	public static List<AnimalDto> converter(List<Animal> animais) {
		return animais.stream().map(AnimalDto::new).collect(Collectors.toList());
	}
		
}
