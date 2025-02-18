package spring.examen.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.examen.modelo.entidades.Reserva;

import java.util.Optional;

@RestController
@RequestMapping("/reserva")
@CacheConfig(cacheNames = "reserva")
public class reservaControlador {
    private reservaService reservaService;
    public reservaControlador() {}
    @Autowired
    public reservaControlador(reservaService reservaService) {
        this.reservaService = reservaService;
    }
    @PostMapping("/reservar")
    @Cacheable(cacheNames = "reserva")
    public ResponseEntity<Reserva> reservar(@Valid @RequestBody Reserva reserva) {
        Optional<Reserva> re = reservaService.reservar(reserva);
        if(re.isPresent()) {
        return ResponseEntity.ok(re.get());
        }else return ResponseEntity.badRequest().body(reserva);
    }
    @PostMapping("/cancelar/{motivo}")
    public ResponseEntity<Reserva> cancelar(@Valid @RequestBody Reserva reserva, @PathVariable String motivo) {
        return ResponseEntity.ok((Reserva) reservaService.cancelar(reserva, motivo).get());
    }

    @GetMapping("/reservas")
    public ResponseEntity<Iterable<Reserva>> listar() {
        return ResponseEntity.ok(reservaService.getAllReservas());
    }
}
