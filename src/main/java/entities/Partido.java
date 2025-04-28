package entities;

import java.time.LocalDate;
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
public class Partido {

	@Id
	private int id;
	
	@Getter @Setter private LocalDate fecha;
	
	@OneToOne
	@Getter @Setter private Estadio estadio;
}
