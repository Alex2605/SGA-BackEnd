package com.clube.sga.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.clube.sga.domain.Departamento;
import com.clube.sga.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
	
	@Autowired
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
