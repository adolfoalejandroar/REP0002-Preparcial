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
import com.example.demo.entities.Estadio;
import com.example.demo.services.EstadioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/estadio")
public class EstadioController {

    @Autowired
    EstadioService estadioServ;

    // ##########################################################
    // GET Methods
    // ##########################################################

    @GetMapping("/list/all")
    @Operation(
            summary = "Obtiene todos los estadios", 
            description = "Devuelve una lista de todos los estadios disponibles en la base de datos")
    public List<Estadio> getEstadios() {
        return estadioServ.get();
    }

    @GetMapping("/list/{id}")
    @Operation(
            summary = "Obtiene un estadio", 
            description = "Devuelve un estadio basado en un id numérico dado")
    public Estadio getEstadio(
            @Parameter(
                    name = "id", 
                    description = "ID del estadio a buscar", 
                    example = "1234", 
                    required = true)
            @PathVariable Integer id) {
        return estadioServ.get(id);
    }

    // ##########################################################
    // POST Methods
    // ##########################################################

    @PostMapping("/post/one")
    @Operation(
            summary = "Crea un estadio", 
            description = "Crea un nuevo registro de estadio en la base de datos")
    public void create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody( 
                    description = "Objeto JSON con los parámetros del estadio",
                    required = true)
            @RequestBody Estadio estadio) {
        estadioServ.post(estadio);
    }

    @PostMapping("/post/more")
    @Operation(
            summary = "Crea varios estadios", 
            description = "Crea varios nuevos registros de estadios en la base de datos a través de una lista de JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    })
    public void create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody( 
                    description = "Objeto JSON con los estadios",
                    required = true)
            @RequestBody List<Estadio> estadios) {
        estadioServ.post(estadios);
    }

    // ##########################################################
    // DELETE Methods
    // ##########################################################

    @DeleteMapping("/del/{id}")
    @Operation(
            summary = "Elimina un estadio por ID", 
            description = "Elimina un registro entre los estadios a través de un ID numérico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Error encontrando el estadio")
    })
    public void delete(
            @Parameter(
                    name = "id",
                    description = "ID del estadio a eliminar",
                    example = "1234",
                    required = true) 
            @PathVariable Integer id) {
        estadioServ.delete(id);
    }

    @DeleteMapping("/del/estadio")
    @Operation(
            summary = "Elimina un estadio por contenido", 
            description = "Elimina un registro entre los estadios a través del contenido de un JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Error encontrando el estadio")
    })
    public void delete(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto JSON con el estadio a eliminar",
                    required = true)
            @RequestBody Estadio estadio) {
        estadioServ.delete(estadio);
    }

    @DeleteMapping("/del/all")
    @Operation(
            summary = "Elimina todos los estadios", 
            description = "Elimina todos los registros de estadios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminados exitosamente"),
            @ApiResponse(responseCode = "404", description = "Error encontrando los estadios")
    })
    public void delete() {
        estadioServ.delete();
    }

    // ##########################################################
    // PUT Methods
    // ##########################################################

    @PutMapping("/put/estadio")
    @Operation(
            summary = "Actualiza un estadio", 
            description = "Actualiza un estadio dado en el registro de la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Error encontrando el estadio")
    })
    public void update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody( 
                    description = "Objeto JSON que ya debe existir en la base de datos",
                    required = true)
            @RequestBody Estadio estadio) {
        if (estadioServ.find(estadio.getId())) {
            estadioServ.put(estadio);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estadio no encontrado");
        }
    }
}

