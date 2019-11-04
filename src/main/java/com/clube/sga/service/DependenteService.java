package com.clube.sga.service;

import java.util.List;

import com.clube.sga.domain.Dependente;

public interface DependenteService {

    void salvar(Dependente dependente);

    void editar(Dependente dependente);

    void excluir(Long id);

    Dependente buscarPorId(Long id);
    
    List<Dependente> buscarTodos();

//	boolean dependenteTemCargos(Long id);
}
