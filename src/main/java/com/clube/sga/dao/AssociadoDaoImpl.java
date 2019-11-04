package com.clube.sga.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.clube.sga.domain.Associado;

@Repository
public class AssociadoDaoImpl extends AbstractDao<Associado, Long> implements AssociadoDao {

	@Override
	public List<Associado> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("select a from Associado a where a.nome like concat('%',?1,'%') ", nome);
	}	
	
	public List<Associado> findByCPF(String CPF) {
		
		return createQuery("select a from Associado a where a.CPF like concat('%',?1,'%') ", CPF);
	}

	@Override
	public List<Associado> findByEmail(String email) {
		// TODO Auto-generated method stub
		return createQuery("select a from Associado a where a.email like concat('%',?1,'%') ", email);
/*
	@Override
	public List<Associado> findByCargoId(Long id) {
		
		return createQuery("select f from Associado f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Associado> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Associado f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Associado> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Associado f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Associado> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Associado f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}	
*/


	}

}
