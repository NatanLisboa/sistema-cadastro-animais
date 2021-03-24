package br.com.animais.sistemacadastroanimais.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String tipo;
	private LocalDateTime dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private SexoAnimal sexo;
	
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

	public Animal() {
	
	}
	
	public Animal(String nome, String tipo, LocalDateTime dataNascimento, SexoAnimal sexo) {
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public Animal(long id, String nome, String tipo, LocalDateTime dataNascimento, SexoAnimal sexo,
			LocalDateTime dataRegistro) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

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

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		
		/* Verifica se a data de nascimento inserida é inferior ou igual à data atual.
		 * Caso não seja, a variável "dataNascimento" não recebe o valor passado. 
		 * */
		
		if (dataNascimento.isBefore(LocalDateTime.now()) || dataNascimento.equals(LocalDateTime.now())) {
			this.dataNascimento = dataNascimento;
		}
		else {
			System.out.println("Data de nascimento inválida!");
		}
		
	}

	public SexoAnimal getSexo() {
		return sexo;
	}

	public void setSexo(SexoAnimal sexo) {
		this.sexo = sexo;
	}	
	
	
}
