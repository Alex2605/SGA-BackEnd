package com.clube.sga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clube.sga.DTO.AssociadoDTO;
import com.clube.sga.domain.Associado;
import com.clube.sga.domain.enums.EstadoCivil;
import com.clube.sga.domain.enums.TipoAssociado;
import com.clube.sga.repositories.AssociadoRepository;
import com.clube.sga.repositories.EnderecoRepository;
import com.clube.sga.services.exceptions.DataIntegrityException;
import com.clube.sga.services.exceptions.ObjectNotFoundException;



@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository repo;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Associado find(Integer id) {
		Optional<Associado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(    
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Associado.class.getName())); 
	}	
	
	@Transactional
	public Associado insert(Associado obj) {
		obj.setId(null);
		obj = repo.save(obj);
//		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Associado update(Associado obj) {
		Associado newObj =  find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há dependentes ou visitantes relacionados");
			}
	}
	
	public List<Associado> findAll(){
		return repo.findAll();
	}
/*
	public Page<Associado> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	
	}
*/	

	public Associado fromDTO(AssociadoDTO objDto) {
		
		Associado obj = new Associado(objDto.getNome(), objDto.getCPF(), objDto.getDataNascimento(), EstadoCivil.toEnum(objDto.getEstadoCivil()), 
									  objDto.getDataNascimento(), TipoAssociado.toEnum(objDto.getTipoAssociado()));
		return obj;
		
	}
	
	private void updateData(Associado newObj, Associado obj) {
		newObj.setNome(obj.getNome());
		//newObj.setEmail(obj.getEmail());
		
	}

}
