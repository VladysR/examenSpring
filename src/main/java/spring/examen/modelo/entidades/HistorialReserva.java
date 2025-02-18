package spring.examen.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "historial_reservas")
public class HistorialReserva {
    @Id
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @Size(max = 200)
    @Column(name = "motivo", length = 200)
    private String motivo;

}