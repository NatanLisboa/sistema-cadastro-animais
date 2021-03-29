package br.com.animais.sistemacadastroanimais.controller;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.animais.sistemacadastroanimais.model.Animal;
import br.com.animais.sistemacadastroanimais.model.SexoAnimal;
import br.com.animais.sistemacadastroanimais.repository.AnimalRepository;
import lombok.Getter;
import lombok.Setter;

/* Definições
 * 	@NotNull: O atributo não pode estar nulo no momento da requisição de cadastramento
 * 	@NotEmpty: O valor do atributo não pode estar vazio no momento da requisição de cadastramento (Ex.: "")
 *  @Getter: Anotação do Lombok para criar um método get para cada atributo da classe que recebeu a anotação, nesse caso
 *  @Setter: Anotação do Lombok para criar um método set para cada atributo da classe que recebeu a anotação, nesse caso
 */

/* Classe que define a forma de como os animais serão modificados pelo usuário */
@Getter
@Setter
public class AtualizacaoAnimalForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String tipo;
	
	@NotNull
	private Date dataNascimento;
	
	@NotNull
	private SexoAnimal sexo;

	
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
