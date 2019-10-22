package com.clube.sga.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clube.sga.DTO.AssociadoDTO;
import com.clube.sga.domain.Associado;
import com.clube.sga.services.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoResource {
	
	@Autowired
	AssociadoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AssociadoDTO>> findAll() {
		List<Associado> list = service.findAll();	
		List<AssociadoDTO> listDto = list.stream().map(obj -> new AssociadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Associado> find(@PathVariable Integer id) {
		Associado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AssociadoDTO> insert(@Valid @RequestBody AssociadoDTO objDto){
		Associado obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AssociadoDTO objDto, @PathVariable Integer id){
		Associado obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
/*	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<AssociadoDTO>> findPage(
			@RequestParam(value = "page",defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction",defaultValue = "ASC") String direction) {
		Page<Associado> list = service.findPage(page, linesPerPage, orderBy, direction);	
		Page<AssociadoDTO> listDto = list.map(obj -> new AssociadoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
*/
}
