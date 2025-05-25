package com.ejemplo.demostracion;

import dominio.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
public class PrimerRestController {



    private List<Persona> personas;

    public PrimerRestController(List<Persona> personas) {
        this.personas = new ArrayList<>(
                Arrays.asList(
                        new Persona(1L, "lautaro", "martinez", "lau@gmail.com"),
                        new Persona(2L, "juan", "villalba", "juan@gmail.com"),
                        new Persona(3L, "pedro", "verne", "pedro@gmail.com")
                )
        );
    }

    @GetMapping()
    public List<Persona> getPersonas() {
        return personas;
    }

    @GetMapping("/filtros")
    public ResponseEntity<?> buscarPersonaPorNombreApellido(@RequestParam(required = false) String nombre,
                                                        @RequestParam(required = false) String apellido) {

        if (nombre == null && apellido == null) {
            return ResponseEntity.badRequest().body("Nombre y apellido vacio");

        }

        List<Persona> response = new ArrayList<>();

        if (nombre != null) {
            response.addAll(
                    this.personas.stream()
                            .filter(persona -> persona.getNombre().equalsIgnoreCase(nombre))
                            .collect(Collectors.toList())
            );
        }

        if (apellido != null) {
            this.personas.stream()
                    .filter(persona -> persona.getApellido().equalsIgnoreCase(apellido))
                    .forEach(persona -> {
                        if (!response.contains(persona)) {
                            response.add(persona);
                        }
                    });
        }

        return ResponseEntity.ok(response);
    }



    @GetMapping("/email/{mail}")
    public ResponseEntity<?> buscarPersonaPorMail(@PathVariable String mail){

        if (mail == null) {
            return ResponseEntity.badRequest().body("Nombre y apellido vacio");

        }
            return this.personas
                .stream()
                .filter(persona -> persona.getEmail().equals(mail))
                .findFirst().
                orElse(new Persona(null,null,null,null));
    }


    @PostMapping("")
    public ResponseEntity<Persona> crear(@RequestBody Persona persona){
        persona.setCodigo((long) this.personas.size() + 1);
        this.personas.add(persona);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(persona);
    }


    @PutMapping("{codigo}")
    public Persona editar(@PathVariable long codigo,
            @RequestBody Persona persona){

        if(!esCodigoEsxistente(codigo)){
            throw new RuntimeException("NO existe persona con ese ID");
        }
        return this.personas.
                stream()
                .filter(per -> per.getCodigo().equals(codigo))
                .peek(per -> {
                    per.setApellido(persona.getApellido());
                    per.setNombre((persona.getNombre()));
                    per.setEmail(persona.getEmail());
                })
                .findFirst().get();


    }

    private boolean esCodigoEsxistente(long codigo){
        return this.personas.stream().anyMatch(persona -> persona.getCodigo().equals(codigo));
    }

    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable long codigo){
        if(!esCodigoEsxistente(codigo)){
            throw new RuntimeException("NO existe persona con ese ID");
        }

        this.personas.removeIf(persona -> persona.getCodigo().equals(codigo));
    }

}
