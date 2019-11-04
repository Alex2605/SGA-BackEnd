package com.clube.sga.service;

import java.util.List;

import com.clube.sga.domain.Visitante;

public interface VisitanteService {

    void salvar(Visitante visitante);

    void editar(Visitante visitante);

    void excluir(Long id);

    Visitante buscarPorId(Long id);
    
    List<Visitante> buscarTodos();

//	boolean visitanteTemCargos(Long id);
}
