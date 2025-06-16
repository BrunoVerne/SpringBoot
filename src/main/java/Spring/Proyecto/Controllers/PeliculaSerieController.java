package Spring.Proyecto.Controllers;

import Spring.Proyecto.domain.PeliculaSerie;
import Spring.Proyecto.services.PeliculaSerieService;
import Spring.Proyecto.services.PeliculaSerieServiceImpDB;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/PeliculaSerie")
public class PeliculaSerieController {
    private final PeliculaSerieService peliculaSerieService;

    public PeliculaSerieController(PeliculaSerieService peliculaSerieService) {
        this.peliculaSerieService = peliculaSerieService;
    }

    public  ResponseEntity<?> bucarPorTitulo(@PathVariable String titulo){
        PeliculaSerie response = this.peliculaSerieService.buscarPorTitulo(titulo);
        if(response == null){
            return ResponseEntity.
                    notFound().
                    build();
        }
        return ResponseEntity.ok(response) ;
    }

}
