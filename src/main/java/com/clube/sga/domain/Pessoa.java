package com.clube.sga.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.clube.sga.domain.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String CPF;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dataNascimento;
	private Integer estadoCivil;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dataInscricao;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dataEncerramento;

	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	@OneToMany(mappedBy = "pessoa")
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	@ElementCollection
	@CollectionTable(name = "EMAIL")
	private Set<String> emails = new HashSet<>();
	
	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String CPF, Date dataNascimento, EstadoCivil estadoCivil, Date dataInscricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil.getCod();
		this.dataInscricao = dataInscricao;
	}
	
	public Pessoa(String nome, String CPF, Date dataNascimento, EstadoCivil estadoCivil, Date dataInscricao) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil.getCod();
		this.dataInscricao = dataInscricao;
	}	

	public Pessoa(Integer id, String nome, String CPF, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
	}

	

	public Pessoa(String nome, String CPF, Date dataNascimento) {
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(estadoCivil);
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil.getCod();
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
	
