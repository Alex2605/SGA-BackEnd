package com.clube.sga.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.clube.sga.domain.Dependente;

@Repository
public class DependenteDaoImpl extends AbstractDao<Dependente, Long> implements DependenteDao {

	public List<Dependente> findByNome(String nome) {
		
		return createQuery("select f from Dependente f where f.nome like concat('%',?1,'%') ", nome);
	}
/*
	@Override
	public List<Dependente> findByCargoId(Long id) {
		
		return createQuery("select f from Dependente f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Dependente> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Dependente f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Dependente> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Dependente f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Dependente> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Dependente f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}	
*/	
}
