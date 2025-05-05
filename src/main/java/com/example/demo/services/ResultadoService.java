package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Resultado;
import com.example.demo.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	ResultadoRepository resultadoRep;

	// #############################
	// Get Methods
	// #############################

	public List<Resultado> get() {
		List<Resultado> resultado = resultadoRep.findAll();
		resultado.forEach(res -> {
			if (res != null) {
				res.getPartido().setResultados(null);
				res.getPartido().setEstadio(null);
				res.getSeleccion().setResultados(null);
				res.getSeleccion().setContinente(null);
			}
		});
		return resultado;
	}

	public Resultado get(int id) {
		Resultado resultado = resultadoRep.findById(id).orElse(null);
		if (resultado != null) {
			resultado.getPartido().setResultados(null);
			resultado.getPartido().setEstadio(null);
			resultado.getSeleccion().setResultados(null);
			resultado.getSeleccion().setContinente(null);
		}
		return resultado;
	}

	// #############################
	// Post Methods
	// #############################

	public void post(Resultado resultado) {
		resultadoRep.save(resultado);
	}

	public void post(List<Resultado> resultado) {
		resultadoRep.saveAll(resultado);
	}

	// #############################
	// Delete Methods
	// #############################

	public void delete(int id) {
		resultadoRep.deleteById(id);
	}

	public void delete(Resultado resultado) {
		resultadoRep.delete(resultado);
	}

	public void delete() {
		resultadoRep.deleteAll();
	}

	// #############################
	// Update Methods
	// #############################

	public void put(Resultado resultado) {
		resultadoRep.save(resultado);
	}

	// #############################
	// Test Methods
	// #############################

	public Boolean find(int id) {
		return resultadoRep.existsById(id);
	}

	public Boolean find(Resultado resultado) {
		return resultadoRep.exists(Example.of(resultado));
	}
}
