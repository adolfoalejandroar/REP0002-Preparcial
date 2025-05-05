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

import com.example.demo.entities.Resultado;
import com.example.demo.services.ResultadoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoService resultadoServ;

    // ##########################################################
    // GET Methods
    // ##########################################################

    @GetMapping("/list/all")
    public List<Resultado> getResultados() {
        return resultadoServ.get();
    }

    @GetMapping("/list/{id}")
    public Resultado getResultado(@PathVariable int id) {
        return resultadoServ.get(id);
    }

    // ##########################################################
    // POST Methods
    // ##########################################################

    @PostMapping("/post/one")
    public void create(@RequestBody Resultado resultado) {
        resultadoServ.post(resultado);
    }

    @PostMapping("/post/more")
    public void create(@RequestBody List<Resultado> resultados) {
        resultadoServ.post(resultados);
    }

    // ##########################################################
    // DELETE Methods
    // ##########################################################

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable int id) {
        resultadoServ.delete(id);
    }

    @DeleteMapping("/del/resultado")
    public void delete(@RequestBody Resultado resultado) {
        resultadoServ.delete(resultado);
    }

    @DeleteMapping("/del/all")
    public void delete() {
        resultadoServ.delete();
    }

    // ##########################################################
    // PUT Methods
    // ##########################################################

    @PutMapping("/put/resultado")
    public void update(@RequestBody Resultado resultado) {
        if (resultadoServ.find(resultado.getId())) {
            resultadoServ.put(resultado);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resultado no encontrado");
        }
    }
}

