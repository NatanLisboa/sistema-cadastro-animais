package br.com.animais.sistemacadastroanimais.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Classe que representará o objeto do tipo Animal no banco de dados (Classe de modelo de domínio) */
@Data /* Notação do Lombok que cria um construtor com todos os campos, getters e setters automaticamente */
@NoArgsConstructor /* Notação do Lombok que cria um construtor vazio */
@Entity /* Notação que informa ao programa que essa classe representará uma entidade no banco de dados */
public class Animal {
	
	@Id /* Notação que informa ao programa que esse atributo representará o campo identificador (chave primária) no banco de dados */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* Notação que informa ao programa que, no momento do mapeamento objeto-relacional, a constraint IDENTITY será utilizada, a fim de gerar os valores para os ids dos registros automaticamente */
	private long id;

	private String nome;
	
	private String tipo;
	
	@Temporal(TemporalType.DATE) /* Notação que informa ao programa que o atributo é do tipo Date quando ele for mapeado para o banco de dados*/ 
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING) /* Notação que informa ao programa que o atributo é do tipo Enum quando ele for mapeado para o banco de dados, além de dizer ao banco para guardar o conteúdo da mensagem por meio da notação EnumType.STRING */ 
	private SexoAnimal sexo;	
	
	/* CONSTRUTORES MODIFICADOS */
	public Animal(String nome, String tipo, Date dataNascimento, SexoAnimal sexo) {
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	
}
