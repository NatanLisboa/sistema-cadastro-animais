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

/* Classe que representará o objeto do tipo Animal no banco de dados (Classe de modelo de domínio) */

@Entity /* Notação que informa ao programa que essa classe representará uma entidade no banco de dados */
public class Animal {
	
	@Id /* Notação que informa ao programa que esse atributo representará o campo identificador (chave primária) no banco de dados */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* Notação que informa ao programa que, no momento do mapeamento objeto-relacional, a constraint IDENTITY será utilizada,
	 													 * a fim de gerar os valores para os ids dos registros automaticamente
	 													 */ 
	private long id;
	
	private String nome;
	private String tipo;
	
	@Temporal(TemporalType.DATE) /* Notação que informa ao programa que o atributo é do tipo Date quando ele for mapeado para o banco de dados*/ 
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING) /* Notação que informa ao programa que o atributo é do tipo Enum quando ele for mapeado para o banco de dados,
	 							  *	além de dizer ao banco para guardar o conteúdo da mensagem por meio da notação EnumType.STRING */ 
	private SexoAnimal sexo;
	
	
	/* MÉTODO HASH CODE */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	/* MÉTODO EQUALS */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	/* CONSTRUTORES */
	public Animal() {
	
	}
	
	public Animal(String nome, String tipo, Date dataNascimento, SexoAnimal sexo) {
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public Animal(long id, String nome, String tipo, Date dataNascimento, SexoAnimal sexo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	/* MÉTODOS GETTERS E SETTERS */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
	
	
}
