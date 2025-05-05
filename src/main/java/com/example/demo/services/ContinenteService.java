package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Continente;
import com.example.demo.repository.ContinenteRepository;

/**
 * This controller handles CRUD operations for the "Seleccion" entity. It
 * provides endpoints to create, read, update, and delete "Seleccion" objects.
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
 *     "nombre": "Argentina",
 *     "continente": "América"
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
 *       "nombre": "Argentina",
 *       "continente": "América"
 *     },
 *     {
 *       "nombre": "España",
 *       "continente": "Europa"
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
 *     "nombre": "Argentina",
 *     "continente": "América"
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
 *     "nombre": "Argentina",
 *     "continente": "América"
 *   }
 * </pre>
 * </ul>
 */
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
			}
		});
		return continentes;
	}

	public Continente get(int id) {
		Continente continente = continenteRep.findById(id).orElse(null);
		if (continente != null)
			continente.getSelecciones().forEach(seleccion -> seleccion.setContinente(null));
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
