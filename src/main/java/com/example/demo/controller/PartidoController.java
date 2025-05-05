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
import com.example.demo.entities.Partido;
import com.example.demo.services.PartidoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoService partidoServ;

    // ##########################################################
    // GET Methods
    // ##########################################################

    @GetMapping("/list/all")
    public List<Partido> getPartidos() {
        return partidoServ.get();
    }

    @GetMapping("/list/{id}")
    public Partido getPartido(@PathVariable int id) {
        return partidoServ.get(id);
    }

    // ##########################################################
    // POST Methods
    // ##########################################################

    @PostMapping("/post/one")
    public void create(@RequestBody Partido partido) {
        partidoServ.post(partido);
    }

    @PostMapping("/post/more")
    public void create(@RequestBody List<Partido> partidos) {
        partidoServ.post(partidos);
    }

    // ##########################################################
    // DELETE Methods
    // ##########################################################

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id) {
        partidoServ.delete(id);
    }

    @DeleteMapping("/del/partido")
    public void delete(@RequestBody Partido partido) {
        partidoServ.delete(partido);
    }

    @DeleteMapping("/del/all")
    public void delete() {
        partidoServ.delete();
    }

    // ##########################################################
    // PUT Methods
    // ##########################################################

    @PutMapping("/put/partido")
    public void update(@RequestBody Partido partido) {
        if (partidoServ.find(partido.getId())) {
            partidoServ.put(partido);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Partido no encontrado");
        }
    }
}
