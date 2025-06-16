package Spring.Proyecto.Repositories;

import Spring.Proyecto.domain.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PersonajeRepository extends JpaRepository<Personaje,Long>, PagingAndSortingRepository<Personaje, Long> {


}
