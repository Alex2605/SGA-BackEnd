package com.clube.sga.dao;

import java.util.List;

import com.clube.sga.domain.Associado;

public interface AssociadoDao {
    
	void save(Associado associado);

    void update(Associado associado);

    void delete(Long id);

    Associado findById(Long id);

    List<Associado> findAll();
    
    List<Associado> findByCPF(String CPF);

	List<Associado> findByEmail(String email);

	List<Associado> findByNome(String nome);

//	List<Associado> findByCargoId(Long id);

//	List<Associado> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

//	List<Associado> findByDataEntrada(LocalDate entrada);

//	List<Associado> findByDataSaida(LocalDate saida);
}
