package spring.examen.modelo.repositorios;

import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.examen.modelo.entidades.Habitaciones;

import java.util.Optional;

@Repository
public interface habitacionesRepo extends CrudRepository<Habitaciones,String> {
    Optional<Habitaciones> getHabitacionesByIdHabitacion(@Size(max = 10) String idHabitacion);
}
