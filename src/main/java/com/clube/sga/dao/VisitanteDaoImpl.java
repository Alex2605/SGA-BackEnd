package com.clube.sga.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.clube.sga.domain.Visitante;

@Repository
public class VisitanteDaoImpl extends AbstractDao<Visitante, Long> implements VisitanteDao {

	public List<Visitante> findByNome(String nome) {
		
		return createQuery("select f from Visitante f where f.nome like concat('%',?1,'%') ", nome);
	}
/*
	@Override
	public List<Visitante> findByCargoId(Long id) {
		
		return createQuery("select f from Visitante f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Visitante> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Visitante f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Visitante> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Visitante f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Visitante> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Visitante f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}	
*/	
}
