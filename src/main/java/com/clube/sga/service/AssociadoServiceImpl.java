package com.clube.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clube.sga.dao.AssociadoDao;
import com.clube.sga.domain.Associado;

@Service
public class AssociadoServiceImpl implements AssociadoService {
	
	@Autowired
	private AssociadoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Associado associado) {
		dao.save(associado);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Associado associado) {
		dao.update(associado);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Associado buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Associado> buscarTodos() {
		
		return dao.findAll();
	}
/*
	@Override
	public boolean associadoTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
*/

	@Override
	public List<Associado> buscarPorCPF(String CPF) {
		// TODO Auto-generated method stub
		return dao.findByCPF(CPF);
	}

	@Override
	public List<Associado> buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public List<Associado> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}
}
