package spring.examen.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.examen.modelo.entidades.HistorialReserva;
@Repository
public interface historialRepo extends CrudRepository<HistorialReserva,String> {
}
