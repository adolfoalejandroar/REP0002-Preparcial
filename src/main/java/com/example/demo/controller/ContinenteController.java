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
import com.example.demo.entities.Continente;
import com.example.demo.services.ContinenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/continente")
public class ContinenteController {

	@Autowired
	ContinenteService continenteServ;

	// ##########################################################
	// GET Methods
	// ##########################################################

	@GetMapping("/list/all")
	@Operation(
			summary = "Obtiene todos los continentes", 
			description = "Devuelve una lista de todos los continentes disponibles en la base de datos")
	public List<Continente> getContinentes() {
		System.out.println("\n** GET CONTINENTS [ALL] **\n");
		return continenteServ.get();
	}
	
	// ----------------------------------------------------------

	@GetMapping("/list/{id}")
	@Operation(
			summary = "Obtiene un continente", 
			description = "Devuelve un continente basado en un id numérico dado")
	public Continente getContinente(
			@Parameter(
			        name = "id", 
			        description = "ID del continente a buscar", 
			        example = "1234", 
			        required = true)
			@PathVariable Integer id) {
		System.out.println("\n** GET CONTINENT [ID] **\n");
		return continenteServ.get(id);
	}

	// ##########################################################
	// POST Methods
	// ##########################################################

	@PostMapping("/post/one")
	@Operation(
			summary = "Crea un continente", 
			description = "Crea un nuevo registro de continente en la base de datos")
	public void create(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON con los parámetros del continente",
					required = true)
			@RequestBody Continente continente) {
		System.out.println("\n** POST CONTINENT [JSON] **\n");
		continenteServ.post(continente);
	}
	
	// ----------------------------------------------------------
	
	@PostMapping("/post/more")
	@Operation(
			summary = "Crea varios continentes", 
			description = "Crea varios nuevos registros de continentes en la base de datos a través de una lista de JSON")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Eliminado exitosamente"),
		    @ApiResponse(responseCode = "404", description = "Error encontrando el continente")
		})
	public void create(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON con los continentes",
					required = true)
			@RequestBody List<Continente> continentes) {
		System.out.println("\n** POST CONTINENTS [LIST] **\n");
		continenteServ.post(continentes);
	}

	// ##########################################################
	// DETELE Methods
	// ##########################################################

	@DeleteMapping("/del/{id}")
	@Operation(
			summary = "Elimina un continente por ID", 
			description = "Elimina un registro entre los continentes a través de un ID numérico")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Eliminado exitosamente"),
		    @ApiResponse(responseCode = "404", description = "Error encontrando el continente")
		})
	public void delete(
			@Parameter(
					name = "id",
					description = "ID del continente a eliminar",
					example = "1234",
					required = true) 
			@PathVariable Integer id) {
		System.out.println("\n** DELETE CONTINENT [ID] **\n");
		continenteServ.delete(id);
	}
	
	
	// ----------------------------------------------------------
	
	@DeleteMapping("/del/continent")
	@Operation(
			summary = "Elimina un continente por contenido", 
			description = "Elimina un registro entre los continentes a través del contenido de un JSON")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Eliminado exitosamente"),
		    @ApiResponse(responseCode = "404", description = "Error encontrando el continente")
		})
	public void delete(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Objeto JSON con el continente a eliminar",
					required = true)
			@RequestBody Continente continente) {
		System.out.println("\n** DELETE CONTINENT [JSON] **\n");
		continenteServ.delete(continente);
	}
	
	// ----------------------------------------------------------
	
	@DeleteMapping("/del/all")
	@Operation(
			summary = "Elimina todos los continentes", 
			description = "Elimina todos los registros de continentes")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Eliminados exitosamente"),
		    @ApiResponse(responseCode = "404", description = "Error encontrando el continente")
		})
	public void delete() {
		System.out.println("\n** DELETE CONTINENT [ALL] **\n");
		continenteServ.delete();
	}

	// ##########################################################
	// PUT Methods
	// ##########################################################
	
	@PutMapping("/put/continent")
	@Operation(
			summary = "Actualiza un continente", 
			description = "Actualiza un continente dado en el registro de la base de datos")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Actualizado exitosamente"),
		    @ApiResponse(responseCode = "404", description = "Error encontrando el continente")
		})
	public void update(
			@io.swagger.v3.oas.annotations.parameters.RequestBody( 
					description = "Objeto JSON que ya debe existir en la base de datos",
					required = true)
			@RequestBody Continente continente) {
		if(continenteServ.find(continente.getId())) {
			System.out.println("\n** DELETE CONTINENT [JSON] **\n");
			continenteServ.put(continente);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Continente no encontrado");
		}
	}
}
