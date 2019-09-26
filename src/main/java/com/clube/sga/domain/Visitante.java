package com.clube.sga.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.clube.sga.domain.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Visitante extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	public Visitante() {
	}

	public Visitante(Integer id, String nome, String CPF, Date dataNascimento, EstadoCivil estadoCivil,
			Date dataInscricao) {
		super(id, nome, CPF, dataNascimento, estadoCivil, dataInscricao);
		
	}


	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	
	
}
