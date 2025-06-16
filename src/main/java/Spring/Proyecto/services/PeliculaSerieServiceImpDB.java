package Spring.Proyecto.services;

import Spring.Proyecto.Repositories.PeliculaSerieRepository;
import Spring.Proyecto.domain.PeliculaSerie;

public class PeliculaSerieServiceImpDB implements PeliculaSerieService{
    private final PeliculaSerieRepository  peliculaSerieRepository;

    public PeliculaSerieServiceImpDB(PeliculaSerieRepository peliculaSerieRepository) {
        this.peliculaSerieRepository = peliculaSerieRepository;
    }

    @Override
    public PeliculaSerie buscarPorTitulo(String titulo) {
        return this.peliculaSerieRepository.buscarPorTitulo(titulo).orElse(null);
    }

}
