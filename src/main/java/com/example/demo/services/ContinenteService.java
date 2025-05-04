package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Continente;
import com.example.demo.repository.ContinenteRepository;

@Service
public class ContinenteService {

	@Autowired
	ContinenteRepository continenteRep;
	
	List<Continente> continentes = new ArrayList<>();

	/**
	 * Encontrar todos
	 * @return Lista de continentes
	 */
	public List<Continente> getContinentes(){
		return continenteRep.findAll();
	}
	
	/**
	 * Para el Post
	 * @param continente
	 */
	public void post(Continente continente) {
		continenteRep.save(continente);
	}
	
	public void delete(int id) {
		continenteRep.deleteById(id);
	}
	
	public void delete(Continente continente) {
		continenteRep.delete(continente);
	}
}
