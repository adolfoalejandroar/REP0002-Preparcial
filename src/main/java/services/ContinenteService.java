package services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Continente;
import repository.ContinenteRepository;

@Service
public class ContinenteService {

	@Autowired
	ContinenteRepository continenteRep;
	
	List<Continente> continentes = new ArrayList<>();

	
	public List<Continente> getContinentes(){
		return continenteRep.findAll();
	}
	
}
