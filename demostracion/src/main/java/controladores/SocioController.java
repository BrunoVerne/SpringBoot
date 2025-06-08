package controladores;


import com.google.common.collect.Lists;
import dominio.Socio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicios.SocioService;
import servicios.SocioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService){
        this.socioService = socioService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSocios(){
        return ResponseEntity.ok(this.socioService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(Long id){
        Socio response = socioService.getById(id);
        if(response == null){
            return ResponseEntity
                    .notFound()
                    .build();

        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> crateSocio(@RequestBody Socio socio){
        Socio response = socioService.createSocio(socio);
        if(response == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(socio);
    }






}
