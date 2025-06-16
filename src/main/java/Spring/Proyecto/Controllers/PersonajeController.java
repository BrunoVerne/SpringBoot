package Spring.Proyecto.Controllers;

import Spring.Proyecto.domain.Personaje;
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
       Personaje response = this.personajeService.getById(id);
        if(response == null){
            return ResponseEntity.
                    notFound()
                    .build();
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<?> createPersonaje(@RequestBody Personaje personaje){
         Personaje response = this.personajeService.createPersonaje(personaje);

        if(response == null){
            return ResponseEntity.
                    status(HttpStatus.CONFLICT).
                    body("el mail ya existe");
        }
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(personaje);
    }

    @GetMapping("/paginado")
    public ResponseEntity<?> paginado(Pageable paginado){
        return ResponseEntity.ok(this.personajeService.paginado(paginado));

    }
}

