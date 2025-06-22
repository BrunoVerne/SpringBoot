package Spring.Proyecto.services;

import Spring.Proyecto.Repositories.PeliculaSerieRepository;
import Spring.Proyecto.domain.PeliculaSerie;
import Spring.Proyecto.exception.PeliculaSerieExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaSerieServiceImpDB implements PeliculaSerieService{
    private final PeliculaSerieRepository  peliculaSerieRepository;

    public PeliculaSerieServiceImpDB(PeliculaSerieRepository peliculaSerieRepository) {
        this.peliculaSerieRepository = peliculaSerieRepository;
    }

    @Override
    public PeliculaSerie buscarPorTitulo(String titulo) {
        Optional<PeliculaSerie> oPeliculaSerie = this.peliculaSerieRepository.buscarPorTitulo(titulo);
        if(oPeliculaSerie.isEmpty()){
            throw new PeliculaSerieExistException(String.format("la pelicula con titulo %s no existe", titulo));
        }
        return oPeliculaSerie.get();
    }

    public PeliculaSerie findById(Long id){
        Optional<PeliculaSerie> oPeliculaSerie = this.peliculaSerieRepository.findById(id);
        if(oPeliculaSerie.isEmpty()){
            throw new PeliculaSerieExistException("la pelicula con ese id no existe");
        }
        return oPeliculaSerie.get();
    }

    @Override
    public List<PeliculaSerie> getAllPeliculaSerie() {
        return (List<PeliculaSerie>)this.peliculaSerieRepository.findAll();
    }

    @Override
    public PeliculaSerie createPeliculaSerie(PeliculaSerie peliculaSerie) {
        Optional<PeliculaSerie> oPeliculaSerie = this.peliculaSerieRepository.findById(peliculaSerie.getCodigo());
        if(oPeliculaSerie.isPresent()){
            throw new PeliculaSerieExistException("la pelicula/serie ya existe");
        }
        return oPeliculaSerie.get();
    }

}
