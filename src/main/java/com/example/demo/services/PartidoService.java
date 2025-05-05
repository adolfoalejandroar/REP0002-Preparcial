package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Partido;
import com.example.demo.repository.PartidoRepository;

@Service
public class PartidoService {

	@Autowired
	PartidoRepository partidoRep;

	// #############################
	// Get Methods
	// #############################

	public List<Partido> get() {
		List<Partido> partidos = partidoRep.findAll();
		partidos.forEach(partido -> {
			if (partido != null)
				partido.getEstadio().setPartidos(null);
		});
		return partidos;
	}

	public Partido get(int id) {
		Partido partido = partidoRep.findById(id).orElse(null);
		if (partido != null)
			partido.getEstadio().setPartidos(null);
		return partido;
	}

	// #############################
	// Post Methods
	// #############################

	public void post(Partido partido) {
		partidoRep.save(partido);
	}

	public void post(List<Partido> partidos) {
		partidoRep.saveAll(partidos);
	}

	// #############################
	// Delete Methods
	// #############################

	public void delete(int id) {
		partidoRep.deleteById(id);
	}

	public void delete(Partido partido) {
		partidoRep.delete(partido);
	}

	public void delete() {
		partidoRep.deleteAll();
	}

	// #############################
	// Update Methods
	// #############################

	public void put(Partido partido) {
		partidoRep.save(partido);
	}

	// #############################
	// Test Methods
	// #############################

	public Boolean find(int id) {
		return partidoRep.existsById(id);
	}

	public Boolean find(Partido partido) {
		return partidoRep.exists(Example.of(partido));
	}
}
