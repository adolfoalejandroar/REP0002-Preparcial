package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		List<Continente> continentes = continenteRep.findAll();
		continentes.forEach(continente -> {
			if (continente != null) {
				continente.getSelecciones().forEach(seleccion -> seleccion.setContinente(null));
				continente.getSelecciones().forEach(seleccion -> {
					if (seleccion != null) {
						seleccion.setResultados(null);
					}
				});
			}
		});
		return continentes;
	}

	public Continente get(int id) {
		Continente continente = continenteRep.findById(id).orElse(null);
		if (continente != null)
			continente.getSelecciones().forEach(seleccion -> seleccion.setContinente(null));
		continente.getSelecciones().forEach(seleccion -> {
			if (seleccion != null) {
				seleccion.getResultados().forEach(resultado -> {
					if (resultado != null) {
						resultado.setSeleccion(null);
						resultado.setPartido(null);
					}
				});
			}
		});
		return continente;
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

	// #############################
	// Test Methods
	// #############################

	public Boolean find(int id) {
		return continenteRep.existsById(id);
	}

	public Boolean find(Continente continente) {
		return continenteRep.exists(Example.of(continente));
	}
}
