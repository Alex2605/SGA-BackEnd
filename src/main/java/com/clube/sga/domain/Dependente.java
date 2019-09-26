package com.clube.sga.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.clube.sga.domain.enums.EstadoCivil;
import com.clube.sga.domain.enums.TipoDependente;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dependente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private Integer tipoDependente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;
	
	public Dependente() {
	}

	public Dependente(Integer id, String nome, String CPF, Date dataNascimento, EstadoCivil estadoCivil,
			Date dataInscricao, TipoDependente tipoDependente ) {
		super(id, nome, CPF, dataNascimento, estadoCivil, dataInscricao);
		this.tipoDependente = tipoDependente.getCod();
		
	}

	public TipoDependente tipoDependente() {
		return TipoDependente.toEnum(tipoDependente);
	}

	public void tipoDependente(TipoDependente tipoDependente) {
		this.tipoDependente = tipoDependente.getCod();
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}
	
	
	
	
}
