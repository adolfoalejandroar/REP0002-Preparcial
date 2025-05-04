package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Continente;
import com.example.demo.services.ContinenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/continente")
public class ContinenteController {

	@Autowired
	ContinenteService continenteServ;

	// #############################
	// GET Methods
	// #############################

	@GetMapping("/listar/todos")
	@Operation(
			summary = "Obtiene todos los continentes", 
			description = "Devuelve una lista de todos los continentes disponibles en la base de datos")
	public List<Continente> getContinentes() {
		return continenteServ.get();
	}

	@GetMapping("/listar/{id}")
	@Operation(
			summary = "Obtiene un continente", 
			description = "Devuelve un continente basado en un id numérico dado")
	public Continente getContinente(
			@Parameter(
			        name = "id", 
			        description = "ID del continente a buscar", 
			        example = "1234", 
			        required = true)
			@PathVariable int id) {
		return continenteServ.get(id);
	}

	// #############################
	// POST Methods
	// #############################

	@PostMapping("/post/one")
	@Operation(
			summary = "Crea un continente", 
			description = "Crea un nuevo registro de continente en la base de datos")
	public void create(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON con los parámetros del continente",
					required = true)
			@RequestBody Continente continente) {
		continenteServ.post(continente);
	}
	
	@PostMapping("/post/more")
	@Operation(
			summary = "Crea varios continentes", 
			description = "Crea varios nuevos registros de continentes en la base de datos")
	public void create(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON con los continentes",
					required = true)
			@RequestBody List<Continente> continentes) {
		continenteServ.post(continentes);
	}

	// #############################
	// DETELE Methods
	// #############################

	@DeleteMapping("/del/{id}")
	public void delete(
			@Parameter(
					name = "id",
					description = "ID del continente a eliminar",
					example = "1234",
					required = true) 
			@PathVariable int id) {
		continenteServ.delete(id);
	}
	
	@DeleteMapping("/del/continent")
	public void delete(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Objeto JSON con el continente a eliminar",
					required = true)
			@RequestBody Continente continente) {
		continenteServ.delete(continente);
	}
	
	@DeleteMapping("/del/all")
	public void delete() {
		continenteServ.delete();
	}

	// #############################
	// PUT Methods
	// #############################
	
	@PostMapping("/put/continent")
	@Operation(
			summary = "Actualiza un continente", 
			description = "Actualiza un continente dado en el registro de la base de datos")
	public void update(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON con los continentes",
					required = true)
			@RequestBody Continente continente) {
		if(continenteServ.get(continente.getId()) != null) {
			continenteServ.put(continente);
		}
	}
}
