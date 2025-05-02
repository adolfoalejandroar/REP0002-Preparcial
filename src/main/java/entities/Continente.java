package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class Continente {

	@Id private int id;
	
	@Getter
	@Setter
	private String nombre;
}
