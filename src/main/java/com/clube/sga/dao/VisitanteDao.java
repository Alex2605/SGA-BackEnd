package com.clube.sga.dao;

import java.util.List;

import com.clube.sga.domain.Visitante;

public interface VisitanteDao {
    
	void save(Visitante visitante);

    void update(Visitante visitante);

    void delete(Long id);

    Visitante findById(Long id);

    List<Visitante> findAll();
    
    List<Visitante> findByNome(String nome);

//	List<Visitante> findByCargoId(Long id);

//	List<Visitante> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

//	List<Visitante> findByDataEntrada(LocalDate entrada);

//	List<Visitante> findByDataSaida(LocalDate saida);
}
