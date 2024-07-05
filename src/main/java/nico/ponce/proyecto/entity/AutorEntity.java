package nico.ponce.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutorEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

	@Column(name = "nombres")
    private String nombres;
	
	@Column(name = "apellidos")
    private String apellidos;
	
	@ManyToOne
	@JoinColumn(name = "idpais")
	private PaisEntity pais;
}
