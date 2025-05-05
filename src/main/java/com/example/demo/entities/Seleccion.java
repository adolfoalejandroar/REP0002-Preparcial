package com.example.demo.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "seleccion_id_seq")
    @SequenceGenerator(name = "seleccion_id_seq", sequenceName = "seleccion_id_seq", allocationSize = 1)
	private Integer id;
	
	private String nombre;
	
	private char grupo;
	
	@OneToMany(mappedBy = "seleccion")	
	private List<Resultado> resultados;
	
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente;
}

