package Spring.Proyecto.services;

import Spring.Proyecto.domain.Personaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonajeService {
    List<Personaje> getAllPersonajes();
    Personaje getById(long id);
    Personaje createPersonaje(Personaje personaje);
    Page<Personaje> paginado(Pageable paginado);


}
