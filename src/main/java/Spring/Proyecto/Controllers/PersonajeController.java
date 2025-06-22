package Spring.Proyecto.Controllers;

import Spring.Proyecto.domain.Personaje;
import Spring.Proyecto.exception.PersonajeExistException;
import Spring.Proyecto.exception.PersonajeNotFoundException;
import Spring.Proyecto.services.PersonajeService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }


    @GetMapping
    public ResponseEntity<?> getAllSocios(){
        return ResponseEntity.ok(this.personajeService.getAllPersonajes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Personaje personaje;
       try{
           personaje = this.personajeService.getById(id);
       }catch (PersonajeNotFoundException e){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body(e.getMessage());
       }
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(personaje);

    }


    @PostMapping
    public ResponseEntity<?> createPersonaje(@RequestBody Personaje personaje){
         Personaje response =  this.personajeService.createPersonaje(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/paginado")
    public ResponseEntity<?> paginado(Pageable paginado){
        return ResponseEntity.ok(this.personajeService.paginado(paginado));

    }
}

