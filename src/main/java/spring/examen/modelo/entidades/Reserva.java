package spring.examen.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    @JsonBackReference("habitacion-reserva")
    private Habitaciones idHabitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonBackReference("usuario-reserva")
    private Usuario idUsuario;

    @NotNull
    @Column(name = "fecha_checkin", nullable = false)
    private Instant fechaCheckin;

    @NotNull
    @Column(name = "fecha_checkout", nullable = false)
    private Instant fechaCheckout;

    @Size(max = 20)
    @Column(name = "borrado", length = 20)
    private String borrado;

    @Column(name = "precio")
    private Float precio;

}