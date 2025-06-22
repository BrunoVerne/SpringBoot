package Spring.Proyecto.Controllers;

import Spring.Proyecto.exception.PeliculaSerieExistException;
import Spring.Proyecto.exception.PersonajeExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PersonajeExistException.class)
    public ResponseEntity<?> personajeExiste(PersonajeExistException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler({PeliculaSerieExistException.class})
    public ResponseEntity<?> peliculaSerieExiste(PeliculaSerieExistException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
