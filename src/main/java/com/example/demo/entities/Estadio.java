package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estadio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadio_id_seq")
    @SequenceGenerator(name = "estadio_id_seq", sequenceName = "estadio_id_seq", allocationSize = 1)
	private int id;
	
	private String nombre;
	
	private int capacidad;
	
	@OneToMany(mappedBy="estadio")
	private List<Partido> partidos;
}
