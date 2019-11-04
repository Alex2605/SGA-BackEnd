package com.clube.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clube.sga.dao.DependenteDao;
import com.clube.sga.domain.Dependente;

@Service
public class DependenteServiceImpl implements DependenteService {
	
	@Autowired
	private DependenteDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Dependente dependente) {
		dao.save(dependente);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Dependente dependente) {
		dao.update(dependente);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Dependente buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Dependente> buscarTodos() {
		
		return dao.findAll();
	}
/*
	@Override
	public boolean dependenteTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
*/
}
