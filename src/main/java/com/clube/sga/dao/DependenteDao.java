package com.clube.sga.dao;

import java.util.List;

import com.clube.sga.domain.Dependente;

public interface DependenteDao {
    
	void save(Dependente dependente);

    void update(Dependente dependente);

    void delete(Long id);

    Dependente findById(Long id);

    List<Dependente> findAll();
    
    List<Dependente> findByNome(String nome);

//	List<Dependente> findByCargoId(Long id);

//	List<Dependente> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

//	List<Dependente> findByDataEntrada(LocalDate entrada);

//	List<Dependente> findByDataSaida(LocalDate saida);
}
