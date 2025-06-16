package Spring.Proyecto.Repositories;

import Spring.Proyecto.domain.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie,Long> {
    @Query("FROM PeliculaSerie ps WHERE ps.titulo = ?1 ")
    Optional<PeliculaSerie> buscarPorTitulo(String titulo);

}
