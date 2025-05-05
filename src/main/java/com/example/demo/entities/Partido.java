package com.example.demo.entities;

import java.util.Date;
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
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partido_id_seq")
    @SequenceGenerator(name = "partido_id_seq", sequenceName = "partido_id_seq", allocationSize = 1)
	private int id;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="estadio_id")
	private Estadio estadio;
	
	@OneToMany(mappedBy="partido")
	List<Resultado> resultados;
}
