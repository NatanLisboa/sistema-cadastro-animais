package br.com.animais.sistemacadastroanimais.controller;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;
import br.com.animais.sistemacadastroanimais.repository.AnimalRepository;

/* Classe que define a forma de como os animais serão modificados pelo usuário */
public class AtualizacaoAnimalForm {
	
	/* Atributos que terão seu preenchimento requisitado no momento de atualização, tal que:
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
	
	public String getNome() {
		return nome;
	}
	
	
	/* Métodos GETTERS e SETTERS */
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

	
	/* Método que atualiza o valor de um objeto do tipo Animal, retorno esse objeto atualizado  */
	public Animal atualizarAnimal(Long id, AnimalRepository animalRepository) {
		
		Animal animal = animalRepository.getOne(id);
		
		animal.setNome(this.nome);
		animal.setTipo(this.tipo);
		animal.setDataNascimento(this.dataNascimento);
		animal.setSexo(this.sexo);
		
		return animal;
		
	}
	
}
