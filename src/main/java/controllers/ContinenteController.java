package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entities.Continente;
import services.ContinenteService;

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
}
