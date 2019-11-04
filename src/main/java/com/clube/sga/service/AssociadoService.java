package com.clube.sga.service;

import java.util.List;

import com.clube.sga.domain.Associado;

public interface AssociadoService {

    void salvar(Associado associado);

    void editar(Associado associado);

    void excluir(Long id);

    Associado buscarPorId(Long id);
    
    List<Associado> buscarTodos();

	List<Associado> buscarPorNome(String nome);
	
	List<Associado> buscarPorCPF(String CPF);

	List<Associado> buscarPorEmail(String email);
	
//	boolean associadoTemCargos(Long id);
}
