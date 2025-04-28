package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estadio {

	@Id
	private int id;
	
	@Getter @Setter private String nombre;
	
	@OneToMany
	@Getter @Setter private int capacidad;
}
