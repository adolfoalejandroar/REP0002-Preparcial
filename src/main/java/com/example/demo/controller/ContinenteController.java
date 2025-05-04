package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Continente;
import com.example.demo.services.ContinenteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/continente")
public class ContinenteController {
	
	@Autowired
	ContinenteService continenteServ;
	
	@GetMapping("/test")
	public boolean Grettings() {
		return true;
	}
	
	@GetMapping("/listar")
	public List<Continente> getContinentes() {
		return continenteServ.getContinentes();
	}
	
	@PostMapping
	public void create(@RequestBody Continente continente) {
		System.out.print("continente ID:" + continente.getId());
		System.out.print("continente Nombre:" + continente.getNombre());
		continenteServ.post(continente);
	}
	
	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable int id) {
		continenteServ.delete(id);
	}
}
