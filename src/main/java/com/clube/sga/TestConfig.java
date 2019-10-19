package com.clube.sga;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.clube.sga.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanceDatabase() throws ParseException {
		System.out.println("Passo no bean");
		dbService.instanciateTestDatabase();
		return true;
	}

}
