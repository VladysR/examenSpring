package spring.examen.modelo.repositorios;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.examen.modelo.entidades.Habitaciones;
import spring.examen.modelo.entidades.Reserva;

import java.time.Instant;

@Repository
public interface reservaRepo extends CrudRepository<Reserva,String> {
    boolean getReservasByFechaCheckinAfter(@NotNull Instant fechaCheckinAfter);

    boolean getReservasByFechaCheckinBefore(Instant checkout);

    boolean getReservasByFechaCheckoutAfter(@NotNull Instant fechaCheckoutAfter);

    Reserva getReservasByFechaCheckinBeforeAndIdHabitacion(@NotNull Instant fechaCheckinBefore,
                                                     @NotNull Habitaciones idHabitacion);

    Reserva getReservasByFechaCheckoutAfterAndIdHabitacion(@NotNull Instant fechaCheckoutAfter,
                                                     @NotNull Habitaciones idHabitacion);

    Reserva getReservasById(Integer id);

    Reserva getReservaById(int id);
}
