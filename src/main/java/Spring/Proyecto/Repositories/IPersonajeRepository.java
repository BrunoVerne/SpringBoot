package Spring.Proyecto.Repositories;

import Spring.Proyecto.domain.Personaje;

import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface IPersonajeRepository {

    List<Personaje> getAllPersonajes();
    Optional<Personaje> getById(long id);
    Personaje createPersonaje(Personaje personaje);
    boolean existePersonaje(Personaje personaje);

}
