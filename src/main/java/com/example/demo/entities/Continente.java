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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Continente {
	
	public Continente(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continente_id_seq")
    @SequenceGenerator(name = "continente_id_seq", sequenceName = "continente_id_seq", allocationSize = 1)
	private Integer id;
	
	private String nombre;
	
	@OneToMany(mappedBy="continente")
	private List<Seleccion> selecciones;
	
}
