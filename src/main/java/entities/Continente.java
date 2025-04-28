package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Continente {

	@Id private int id;
	
	@Getter @Setter private String nombre;
}
