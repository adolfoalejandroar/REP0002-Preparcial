package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entities.Seleccion;
import services.SeleccionService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/selecciones")
public class SeleccionController {

	@Autowired
	SeleccionService seleccionServ;
	
	@GetMapping("/test")
	public boolean Grettings() {
		return true;
	}
	
	@GetMapping("/listar")
	public List<Seleccion> getSelecciones() {
		return seleccionServ.getSelecciones();
	}
	
	@PostMapping
	public Seleccion saveSeleccion(@RequestBody Seleccion seleccion) {
	    return seleccionServ.saveSeleccion(seleccion);
	}
	
}
