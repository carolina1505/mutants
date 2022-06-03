package com.mercadoLibre.demo.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadoLibre.demo.Entity.Dna;
import com.mercadoLibre.demo.repository.RepositoryJDBC;
import com.mercadoLibre.demo.service.IPersona;

/**
 * Clase que implementa los métodos de la interface
 * 
 * @author ccardona
 * 
 * @version 1.0, 03/06/2022
 * 
 *
 */



@Service
public class PersonaImpl implements IPersona{
		
	RepositoryJDBC jdbc;
	
	@Autowired
	public PersonaImpl(RepositoryJDBC jdbc) {
		this.jdbc = jdbc;
	}	
	

	@Override
	public void guardarPersona(Dna persona) {
		jdbc.guardarBD(persona);
	}
		
	@Override
	public int consultarH() {		
		return jdbc.consultarH();
	}
	
	@Override
	public int consultarM() {		
		return jdbc.consultarM();
	}



}
