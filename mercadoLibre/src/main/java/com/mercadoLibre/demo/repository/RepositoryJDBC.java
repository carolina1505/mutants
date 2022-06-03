package com.mercadoLibre.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mercadoLibre.demo.Entity.Dna;

/**
 * Interface Repository donde se interacta con la base de datos
 * 
 * @author ccardona
 * 
 * @version 1.0, 03/06/2022
 * 
 *
 */

@Repository
public class RepositoryJDBC<T> {
	
	@Value("${insertar.MySQL:null}")
	private String insertarDNA;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Funcion que inserta un objeto DNA a la base de datos	
	public void guardarBD(Dna dna) {		
		
		String sql = insertarDNA;
		int result = jdbcTemplate.update(sql, dna.getAdn(), dna.getTipo());
		
	}
	

	//Funcion que consulta en BD cantidad de humanos
	public int consultarH() {
	    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM mutants.dna WHERE tipo = \"human\"", Integer.class);
	}	
	
	//Funcion que consulta en BD cantidad de mutantes
	public int consultarM() {
	    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM mutants.dna WHERE tipo = \"mutant\"", Integer.class);
	}


}
