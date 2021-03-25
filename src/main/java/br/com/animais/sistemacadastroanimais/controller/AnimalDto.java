package br.com.animais.sistemacadastroanimais.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;

public class AnimalDto {
	
	private String nome;
	private String tipo;
	private LocalDateTime dataNascimento;
	private SexoAnimal sexo;
	
	public AnimalDto(Animal animal) {
		this.nome = animal.getNome();
		this.tipo = animal.getTipo();
		this.dataNascimento = animal.getDataNascimento();
		this.sexo = animal.getSexo();
	}
	
	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public SexoAnimal getSexo() {
		return sexo;
	}

	public static List<AnimalDto> converter(List<Animal> animais) {
		return animais.stream().map(AnimalDto::new).collect(Collectors.toList());
	}
		
}
