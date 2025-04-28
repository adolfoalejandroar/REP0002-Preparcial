package services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.Seleccion;
import repository.Seleccion_Repository;

@Service
public class Seleccion_Service {
	@Autowired
	Seleccion_Repository seleccionRep;
	
	List<Seleccion> selecciones = new ArrayList<>();

	
	public List<Seleccion> getSelecciones(){
		return seleccionRep.findAll();
	}
	
	public Seleccion saveSeleccion(Seleccion seleccion) {
	    return seleccionRep.save(seleccion);
	}
}
