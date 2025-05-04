package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seleccion {

	@Id
	private int id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente;
	
	private char grupo;
}

