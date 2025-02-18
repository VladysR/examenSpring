package spring.examen.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.examen.modelo.entidades.Habitaciones;
import spring.examen.modelo.repositorios.habitacionesRepo;

import java.util.List;
import java.util.Optional;

@Service
public class habitacionService {
    private habitacionesRepo repo;
    public habitacionService() {}
    @Autowired
    public habitacionService(habitacionesRepo repo) {
        this.repo = repo;
    }
    public Iterable<Habitaciones> getHabitaciones () {
        return repo.findAll();
    }
    public Optional<Habitaciones> getHabitacion (String id) {
        return repo.getHabitacionesByIdHabitacion(id);
    }
    public Optional<Habitaciones> addHabitacion (@Valid Habitaciones habitacion) {
        return Optional.of(repo.save(habitacion));
    }
    public Optional<Boolean> eliminarHabitacion (String id) {
        Optional<Habitaciones> habitacion = getHabitacion(id);
        if (habitacion.isPresent()) {
        repo.deleteById(id);
            return Optional.of(true);
        }else return Optional.of(false);
    }

}
