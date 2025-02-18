package spring.examen.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.examen.modelo.entidades.Habitaciones;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
@CacheConfig(cacheNames = "habitaciones")
public class habitacionControlador {
    private habitacionService service;
    public habitacionControlador() {}
    @Autowired
    public habitacionControlador(habitacionService service) {
        this.service = service;
    }
    @PostMapping("/alta")
    public ResponseEntity<Habitaciones> darAltaHabitacion(@Valid @RequestBody Habitaciones habitacion) {
        if (service.getHabitacion(habitacion.getIdHabitacion()).isEmpty()) {
        return ResponseEntity.ok(service.addHabitacion(habitacion).get());
        } else {return null;}
    }
    @GetMapping("/habitaciones")
    @Cacheable(cacheNames = "habitaciones")
    public ResponseEntity<Iterable<Habitaciones>> getHabitaciones() {
        return ResponseEntity.ok(service.getHabitaciones());
    }
}
