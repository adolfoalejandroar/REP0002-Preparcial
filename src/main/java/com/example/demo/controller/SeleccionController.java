package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.entities.Seleccion;
import com.example.demo.entities.Resultado;
import com.example.demo.services.SeleccionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/selecciones")
public class SeleccionController {

	@Autowired
	SeleccionService seleccionServ;

	// ##########################################################
	// GET Methods
	// ##########################################################

	@GetMapping("/list/all")
	public List<Seleccion> getSelecciones() {
		return seleccionServ.get();
	}

	@GetMapping("/list/{id}")
	public Seleccion getSeleccion(@PathVariable int id) {
		return seleccionServ.get(id);
	}

	// ##########################################################
	// POST Methods
	// ##########################################################

	@PostMapping("/post/one")
	public void create(@RequestBody Seleccion seleccion) {
		seleccionServ.post(seleccion);
	}

	// ----------------------------------------------------------

	@PostMapping("/post/more")
	public void create(@RequestBody List<Seleccion> selecciones) {
		seleccionServ.post(selecciones);
	}

	// ############################################################
	// DELETE Methods
	// ############################################################

	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable int id) {
		seleccionServ.delete(id);
	}

	// ----------------------------------------------------------

	@DeleteMapping("/del/seleccion")
	public void delete(@RequestBody Seleccion seleccion) {
		seleccionServ.delete(seleccion);
	}

	// ----------------------------------------------------------

	@DeleteMapping("/del/all")
	public void delete() {
		seleccionServ.delete();
	}

	// ##########################################################
	// PUT Methods
	// ##########################################################

	@PutMapping("/put/seleccion")
	public void update(@RequestBody Seleccion seleccion) {
		if (seleccionServ.find(seleccion.getId())) {
			seleccionServ.put(seleccion);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seleccion no encontrada");
		}
	}

	// ##########################################################
	// EXTRA Methods
	// ##########################################################
	
	@GetMapping("/list/{id}/results")
	public List<Resultado> getCustom1(@PathVariable int id) {
		return seleccionServ.getCustom1(id);
	}
}
