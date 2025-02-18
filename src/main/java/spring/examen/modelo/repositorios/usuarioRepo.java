package spring.examen.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.examen.modelo.entidades.Usuario;
@Repository
public interface usuarioRepo extends CrudRepository<Usuario,String> {
}
