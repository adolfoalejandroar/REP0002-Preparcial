package entities;

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
	@Getter @Setter private Partido partido;
	
	@OneToOne
	@Getter @Setter private Seleccion seleccion;
	
	@Getter @Setter private int goles;
	
	@Getter @Setter private int amarillas;
	
	@Getter @Setter private int rojas;
}
