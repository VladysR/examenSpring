package spring.examen.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "habitaciones")
public class Habitaciones {
    @Id
    @Size(max = 10)
    @Column(name = "id_habitacion", nullable = false, length = 10)
    @Pattern(regexp = ("^(?:P[0-9])-([0-9]{2})-[ID]$"),message = "El formato de codigo es incorrecto")
    private String idHabitacion;

    @Size(max = 50)
    @Column(name = "tipo", length = 50)
    @Pattern(regexp = ("^\\w+$"),message = "El tipo solo debe contener caracteres alfanumericos")
    private String tipo;

    @Column(name = "planta")
    @Min(value = -9,message = "La planta debe ser de un digito")
    @Max(value=9,message = "La planta debe ser de un digito")
    private Integer planta;

    @Column(name = "numero")
    private Integer numero;

    @Size(max = 1)
    @Column(name = "ubicacion", length = 1)
    @Pattern(regexp = "^([ID])$")
    private String ubicacion;

    @OneToMany(mappedBy = "idHabitacion")
    @JsonManagedReference("habitacion-reserva")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}