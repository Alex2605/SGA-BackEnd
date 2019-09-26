package com.clube.sga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clube.sga.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
