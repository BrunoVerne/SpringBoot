package Spring.Proyecto.Controllers;

import Spring.Proyecto.domain.PeliculaSerie;
import Spring.Proyecto.exception.PeliculaSerieExistException;
import Spring.Proyecto.exception.PeliculaSerieNotFoundException;
import Spring.Proyecto.services.PeliculaSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Pelicula-serie")
public class PeliculaSerieController {
    private final PeliculaSerieService peliculaSerieService;

    public PeliculaSerieController(PeliculaSerieService peliculaSerieService) {
        this.peliculaSerieService = peliculaSerieService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPeliculaSerie() {
        return ResponseEntity.ok(this.peliculaSerieService.getAllPeliculaSerie());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PeliculaSerie response;
        try {
            response = this.peliculaSerieService.findById(id);
        } catch (PeliculaSerieNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> bucarPorTitulo(@PathVariable String titulo) {
        PeliculaSerie response;
        try {
            response = this.peliculaSerieService.buscarPorTitulo(titulo);
        } catch (PeliculaSerieNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> createPeliculaSerie(@RequestBody PeliculaSerie peliculaSerie){
        PeliculaSerie response = this.peliculaSerieService.createPeliculaSerie(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}





