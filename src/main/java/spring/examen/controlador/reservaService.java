package spring.examen.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.examen.modelo.entidades.Habitaciones;
import spring.examen.modelo.entidades.HistorialReserva;
import spring.examen.modelo.entidades.Reserva;
import spring.examen.modelo.repositorios.historialRepo;
import spring.examen.modelo.repositorios.reservaRepo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class reservaService {
    private reservaRepo repo;
    private historialRepo histRepo;
    public reservaService() {}
    @Autowired
    public reservaService(reservaRepo repo, historialRepo histRepo) {
        this.repo = repo;
        this.histRepo = histRepo;
    }

    public Optional<Reserva> reservar(Reserva reserva) {
        Habitaciones habitacion= reserva.getIdHabitacion();
        Instant checkin = reserva.getFechaCheckin();
        Instant checkout = reserva.getFechaCheckout();
        if(checkin.isAfter(Instant.now()) && checkout.isAfter(Instant.now()) ) {
            if(repo.getReservasByFechaCheckinBeforeAndIdHabitacion(checkin,habitacion) == null || repo.getReservasByFechaCheckoutAfterAndIdHabitacion(checkout,habitacion) == null) {
                return Optional.of(repo.save(reserva));

            }return Optional.of(null);
        }return Optional.of(null);
    }
    public Optional<Reserva> cancelar(Reserva reserva,String motivo) {
        Instant checkin = reserva.getFechaCheckin();
        long diff = ChronoUnit.HOURS.between(checkin, Instant.now());
        if(checkin.isAfter(Instant.now()) ) {
            if(diff < 48) {
                reserva.setPrecio((float) (reserva.getPrecio()+(reserva.getPrecio()*0.2)));
            }
            reserva.setBorrado("Borrado");
            HistorialReserva historialReserva = new HistorialReserva();
            historialReserva.setId(reserva.getId());
            historialReserva.setMotivo(motivo);
            histRepo.save(historialReserva);
            return Optional.of(repo.save(reserva));
        } else return Optional.of(null);
    }

    public Optional<Reserva> getReserva(int id) {
        return Optional.of(repo.getReservaById(id));
    }
    public Iterable<Reserva> getAllReservas() {
        return repo.findAll();
    }
}
