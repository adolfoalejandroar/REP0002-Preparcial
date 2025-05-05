package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado_id_seq")
    @SequenceGenerator(name = "resultado_id_seq", sequenceName = "resultado_id_seq", allocationSize = 1)
	private int id;
	
	private int goles;
	
	private int amarillas;
	
	private int rojas;
	
	@OneToOne
	@JoinColumn(name="partido_id")
	@JsonIgnore
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name="seleccion_id")
	@JsonIgnore
	private Seleccion seleccion;
}
