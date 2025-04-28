package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seleccion {

	@Id
	private int id;
	
	@Getter @Setter private String nombre;
	
	@Getter @Setter private Continente continente;
	
	@Getter @Setter private char grupo;
}

