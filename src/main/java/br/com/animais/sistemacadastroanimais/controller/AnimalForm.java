package br.com.animais.sistemacadastroanimais.controller;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;

/* Classe que define a forma de como os animais serão cadastrados pelo usuário */
public class AnimalForm {
	
	/* Atributos que terão seu preenchimento requisitado no momento de cadastramento, tal que:
	 * 	@NotNull: O atributo não pode estar nulo no momento da requisição de cadastramento
	 * 	@NotEmpty: O valor do atributo não pode estar vazio no momento da requisição de cadastramento (Ex.: "")
	 */
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String tipo;
	
	@NotNull
	private Date dataNascimento;
	
	@NotNull
	private SexoAnimal sexo;
	
	
	/* Métodos GETTERS e SETTERS */
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
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public SexoAnimal getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoAnimal sexo) {
		this.sexo = sexo;
	}
	
	/* Método que converte um objeto do tipo AnimalForm para Animal */
	public Animal converterParaAnimal() {
		return new Animal(nome, tipo, dataNascimento, sexo);
	}
	
	
}
