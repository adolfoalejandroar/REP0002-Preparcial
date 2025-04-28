package services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Continente;
import repository.Continente_Repository;

@Service
public class Continente_Service {

	@Autowired
	Continente_Repository continenteRep;
	
	List<Continente> continentes = new ArrayList<>();

	
	public List<Continente> getContinentes(){
		return continenteRep.findAll();
	}
	
}
