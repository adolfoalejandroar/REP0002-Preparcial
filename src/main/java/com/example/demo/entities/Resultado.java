package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

	@Id
	private int id;
	
	@OneToOne
	private Partido partido;
	
	@OneToOne
	private Seleccion seleccion;
	
	private int goles;
	
	private int amarillas;
	
	private int rojas;
}
