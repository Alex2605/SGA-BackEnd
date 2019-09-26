package com.clube.sga.domain;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.clube.sga.domain.enums.EstadoCivil;
import com.clube.sga.domain.enums.TipoAssociado;

@Entity
public class Associado extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private Integer tipoAssociado;
	
	@OneToMany(mappedBy = "associado")
	private List<Dependente> dependentes = new ArrayList<Dependente>();
	@OneToMany(mappedBy = "associado")
	private List<Visitante> visitantes = new ArrayList<Visitante>();
	
	public Associado() {
	}
	
		public Associado(Integer id, String nome, String CPF, Date dataNascimento, EstadoCivil estadoCivil, 
					 Date dataInscricao, TipoAssociado tipoAssociado) {
		super(id, nome, CPF, dataNascimento, estadoCivil, dataInscricao);
		this.tipoAssociado = tipoAssociado.getCod();
	}

	public TipoAssociado getTipoAssociado() {
		return TipoAssociado.toEnum(tipoAssociado);
	}

	public void setTipoAssociado(TipoAssociado tipoAssociado) {
		this.tipoAssociado = tipoAssociado.getCod();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public List<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}
	
	
	
	

}
