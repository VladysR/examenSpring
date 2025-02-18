package spring.examen.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "nombre", length = 20)
    private String nombre;

    @Size(max = 20)
    @Column(name = "apellido", length = 20)
    private String apellido;

    @OneToMany(mappedBy = "idUsuario")
    @JsonManagedReference("usuario-reserva")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}