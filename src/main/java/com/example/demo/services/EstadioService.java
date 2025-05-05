package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Estadio;
import com.example.demo.repository.EstadioRepository;

@Service
public class EstadioService {

	@Autowired
	EstadioRepository estadioRep;

	// #############################
	// Get Methods
	// #############################

	public List<Estadio> get() {
		List<Estadio> estadio = estadioRep.findAll();
		estadio.forEach(varEstadio -> {
			if (varEstadio != null)
				varEstadio.getPartidos().forEach(partido -> {
					if (partido != null) {
						partido.setEstadio(null);
						partido.getResultados().forEach(resultado -> {
							if (resultado != null) {
								resultado.setPartido(null);
								resultado.getSeleccion().setResultados(null);
								resultado.getSeleccion().setContinente(null);
							}
						});
					}
				});
		});
		return estadio;
	}

	public Estadio get(int id) {
		Estadio estadio = estadioRep.findById(id).orElse(null);
		if (estadio != null) {
			estadio.setPartidos(null);
			estadio.getPartidos().forEach(partido -> {
				if (partido != null) {
					partido.setEstadio(null);
					partido.getResultados().forEach(resultado -> {
						if (resultado != null) {
							resultado.setPartido(null);
							resultado.getSeleccion().setResultados(null);
							resultado.getSeleccion().setContinente(null);
						}
					});
				}
			});
		}
		return estadio;
	}

	// #############################
	// Post Methods
	// #############################

	public void post(Estadio estadio) {
		estadioRep.save(estadio);
	}

	public void post(List<Estadio> estadio) {
		estadioRep.saveAll(estadio);
	}

	// #############################
	// Delete Methods
	// #############################

	public void delete(int id) {
		estadioRep.deleteById(id);
	}

	public void delete(Estadio estadio) {
		estadioRep.delete(estadio);
	}

	public void delete() {
		estadioRep.deleteAll();
	}

	// #############################
	// Update Methods
	// #############################

	public void put(Estadio estadio) {
		estadioRep.save(estadio);
	}

	// #############################
	// Test Methods
	// #############################

	public Boolean find(int id) {
		return estadioRep.existsById(id);
	}

	public Boolean find(Estadio estadio) {
		return estadioRep.exists(Example.of(estadio));
	}
}
