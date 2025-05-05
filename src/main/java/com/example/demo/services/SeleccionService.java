package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Seleccion;
import com.example.demo.repository.SeleccionRepository;

/**
 * This service handles CRUD operations for the "Seleccion" entity. It provides
 * methods to create, read, update, and delete "Seleccion" objects.
 *
 * <h2>Example usage:</h2>
 *
 * <ul>
 * <li><b>To retrieve all "Seleccion" objects:</b></li>
 * 
 * <pre>
 * <code>GET /selecciones/list/all</code>
 * </pre>
 *
 * <li><b>To retrieve a specific "Seleccion" by ID:</b></li>
 * 
 * <pre>
 * <code>GET /selecciones/list/{id}</code>
 * </pre>
 *
 * <li><b>To create a single "Seleccion":</b></li>
 * 
 * <pre>
 * <code>POST /selecciones/post/one</code>
 * </pre>
 * 
 * <pre>
 *   {
 *     "nombre": "Marsellesa",
 *     "continente": {
 *       "id": 1
 *     },
 *     "grupo": "A"
 *   }
 * </pre>
 *
 * <li><b>To create multiple "Seleccion" objects:</b></li>
 * 
 * <pre>
 * <code>POST /selecciones/post/more</code>
 * </pre>
 * 
 * <pre>
 *   [
 *     {
 *       "nombre": "Marsellesa",
 *       "continente": {
 *         "id": 1
 *       },
 *       "grupo": "A"
 *     },
 *     {
 *       "nombre": "Santos Caobos",
 *       "continente": {
 *         "id": 1
 *       },
 *       "grupo": "Z"
 *     },
 *     {
 *       "nombre": "Pömeria",
 *       "continente": {
 *         "id": 1
 *       },
 *       "grupo": "A"
 *     },
 *     {
 *       "nombre": "Olivios Verdes",
 *       "continente": {
 *         "id": 2
 *       },
 *       "grupo": "A"
 *     },
 *     {
 *       "nombre": "Red Keepers",
 *       "continente": {
 *         "id": 5
 *       },
 *       "grupo": "B"
 *     }
 *   ]
 * </pre>
 *
 * <li><b>To delete a "Seleccion" by ID:</b></li>
 * 
 * <pre>
 * <code>DELETE /selecciones/del/{id}</code>
 * </pre>
 *
 * <li><b>To delete a specific "Seleccion" object:</b></li>
 * 
 * <pre>
 * <code>DELETE /selecciones/del/seleccion</code>
 * </pre>
 * 
 * <pre>
 *   {
 *     "id": 1,
 *     "nombre": "Marsellesa",
 *     "continente": {
 *       "id": 1
 *     },
 *     "grupo": "A"
 *   }
 * </pre>
 *
 * <li><b>To delete all "Seleccion" objects:</b></li>
 * 
 * <pre>
 * <code>DELETE /selecciones/del/all</code>
 * </pre>
 *
 * <li><b>To update a "Seleccion":</b></li>
 * 
 * <pre>
 * <code>PUT /selecciones/put/seleccion</code>
 * </pre>
 * 
 * <pre>
 *   {
 *     "id": 1,
 *     "nombre": "Marsellesa",
 *     "continente": {
 *       "id": 1
 *     },
 *     "grupo": "A"
 *   }
 * </pre>
 * </ul>
 */

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
		return selecciones;
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
