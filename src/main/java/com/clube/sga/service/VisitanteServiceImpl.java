package com.clube.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clube.sga.dao.VisitanteDao;
import com.clube.sga.domain.Visitante;

@Service
public class VisitanteServiceImpl implements VisitanteService {
	
	@Autowired
	private VisitanteDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Visitante visitante) {
		dao.save(visitante);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Visitante visitante) {
		dao.update(visitante);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Visitante buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Visitante> buscarTodos() {
		
		return dao.findAll();
	}
/*
	@Override
	public boolean visitanteTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
*/
}
