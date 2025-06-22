package Spring.Proyecto.services;

import Spring.Proyecto.domain.PeliculaSerie;

import java.util.List;
import java.util.Optional;

public interface PeliculaSerieService {
    PeliculaSerie buscarPorTitulo(String titulo);
    List<PeliculaSerie> getAllPeliculaSerie();
    PeliculaSerie createPeliculaSerie(PeliculaSerie peliculaSerie);
    PeliculaSerie  findById(Long id);


}
