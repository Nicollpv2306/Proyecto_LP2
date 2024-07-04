package nico.ponce.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

	@Column(name = "email")
    private String email;

	@Column(name = "password")
    private String password;

	@Column(name = "nombres")
    private String nombres;

	@Column(name = "apellidos")
    private String apellidos;
    
    public UsuarioEntity(String email, String password, String nombres, String apellidos) {
        this.email = email;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}

//la tabla se generará como usuario_entity