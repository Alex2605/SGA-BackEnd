package com.clube.sga.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
//import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa<ID extends Serializable> implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String nome;

	@Size(min = 14, max = 14, message = "{Size.pessoa.cpf}")
	@Column(nullable = true, length = 14, unique = true)
	private String CPF;
	
	@NotNull
 	@PastOrPresent(message = "{PastOrPresent.pessoa.dataNascimento}")
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	@Column(name= "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;
	

//	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;	
	
	private String email;

	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pessoa<?> other = (Pessoa<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", CPF=" + CPF + "]";
	}
}
