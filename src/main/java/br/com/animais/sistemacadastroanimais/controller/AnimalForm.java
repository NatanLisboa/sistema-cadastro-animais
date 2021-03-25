package br.com.animais.sistemacadastroanimais.controller;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;

public class AnimalForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String tipo;
	
	@NotNull
	private LocalDateTime dataNascimento;
	
	@NotNull
	private SexoAnimal sexo;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public SexoAnimal getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoAnimal sexo) {
		this.sexo = sexo;
	}

	public Animal converterParaAnimal() {
		return new Animal(nome, tipo, dataNascimento, sexo);
	}
	
	
}
