package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Seleccion;
import com.example.demo.repository.SeleccionRepository;

@Service
public class SeleccionService {
	@Autowired
	SeleccionRepository seleccionRep;
	
	List<Seleccion> selecciones = new ArrayList<>();

	
	public List<Seleccion> getSelecciones(){
		return seleccionRep.findAll();
	}
	
	public Seleccion saveSeleccion(Seleccion seleccion) {
	    return seleccionRep.save(seleccion);
	}
}
