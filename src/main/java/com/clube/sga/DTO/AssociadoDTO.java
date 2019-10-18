package com.clube.sga.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.clube.sga.domain.Associado;

public class AssociadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo nome de preenchimento obrigatório")
	@Length(min=5, max=120, message = "O tamanho do campo nome deve ser entre 5 e 120 caracteres")
	private String nome;
	private String CPF;
	private Date dataNascimento;
	private Integer estadoCivil;
	private Date dataInscricao;
	private Integer tipoAssociado;
	
	public AssociadoDTO() {
	}

	public AssociadoDTO(Associado obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.CPF = obj.getCPF();
		this.dataNascimento = obj.getDataNascimento();
		this.estadoCivil = obj.getEstadoCivil().getCod();
		this.dataInscricao = obj.getDataInscricao();
		this.tipoAssociado = obj.getTipoAssociado().getCod();
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

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Integer getTipoAssociado() {
		return tipoAssociado;
	}

	public void setTipoAssociado(Integer tipoAssociado) {
		this.tipoAssociado = tipoAssociado;
	}
}
