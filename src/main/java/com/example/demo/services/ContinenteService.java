package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Continente;
import com.example.demo.repository.ContinenteRepository;

@Service
public class ContinenteService {

	@Autowired
	ContinenteRepository continenteRep;

	// #############################
	// Get Methods
	// #############################
	
	public List<Continente> get() {
		return continenteRep.findAll();
	}

	public Continente get(int id) {
		return continenteRep.getReferenceById(id);
	}

	// #############################
	// Post Methods
	// #############################

	public void post(Continente continente) {
		continenteRep.save(continente);
	}

	public void post(List<Continente> continentes) {
		continenteRep.saveAll(continentes);
	}

	// #############################
	// Delete Methods
	// #############################

	public void delete(int id) {
		continenteRep.deleteById(id);
	}

	public void delete(Continente continente) {
		continenteRep.delete(continente);
	}
	
	public void delete() {
		continenteRep.deleteAll();
	}

	// #############################
	// Update Methods
	// #############################
	
	public void put(Continente continente) {
		continenteRep.save(continente);
	}
}
