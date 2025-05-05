package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Seleccion;
import com.example.demo.repository.SeleccionRepository;

@Service
public class SeleccionService {

	@Autowired
	SeleccionRepository seleccionRep;

	// #############################
	// Get Methods
	// #############################

	public List<Seleccion> get() {
		List<Seleccion> selecciones = seleccionRep.findAll();
		selecciones.forEach(seleccion -> {
			if (seleccion != null)
				seleccion.getContinente().setSelecciones(null);
		});
		return seleccionRep.findAll();
	}

	public Seleccion get(int id) {
		Seleccion seleccion = seleccionRep.findById(id).orElse(null);
		if (seleccion != null)
			seleccion.getContinente().setSelecciones(null);
		return seleccion;
	}

	// #############################
	// Post Methods
	// #############################

	public void post(Seleccion seleccion) {
		seleccionRep.save(seleccion);
	}

	public void post(List<Seleccion> selecciones) {
		seleccionRep.saveAll(selecciones);
	}

	// #############################
	// Delete Methods
	// #############################

	public void delete(int id) {
		seleccionRep.deleteById(id);
	}

	public void delete(Seleccion seleccion) {
		seleccionRep.delete(seleccion);
	}

	public void delete() {
		seleccionRep.deleteAll();
	}

	// #############################
	// Update Methods
	// #############################

	public void put(Seleccion seleccion) {
		seleccionRep.save(seleccion);
	}

	// #############################
	// Test Methods
	// #############################

	public Boolean find(int id) {
		return seleccionRep.existsById(id);
	}

	public Boolean find(Seleccion seleccion) {
		return seleccionRep.exists(Example.of(seleccion));
	}
}
