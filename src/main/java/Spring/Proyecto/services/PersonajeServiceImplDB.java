package Spring.Proyecto.services;

import Spring.Proyecto.Repositories.PersonajeRepository;
import Spring.Proyecto.domain.Personaje;
import Spring.Proyecto.exception.PersonajeExistException;
import Spring.Proyecto.exception.PersonajeNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary //esto le avisa al repo qué servicio inyectar.
public class PersonajeServiceImplDB implements PersonajeService {
    private final PersonajeRepository personajeRepository; //este service usa el repository de JPA

    public PersonajeServiceImplDB(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return (List<Personaje>)this.personajeRepository.findAll();
    }

    @Override
    /**
     * Ingresa un @id de personaje
     * devuelve el personaje, null si no se lo encontró
     */
    public Personaje getById(long id) {
        Optional<Personaje> response = this.personajeRepository.findById(id);
        if(response.isEmpty()){
            throw new PersonajeNotFoundException("el socio no existe");
        }
        return response.get();
    }

    @Override
    public Personaje createPersonaje(Personaje personaje) {
        Optional<Personaje> oPersonaje = this.personajeRepository.findById(personaje.getId());
        if(oPersonaje.isPresent()){
            throw new PersonajeExistException("el id del personaje ya existe");
        }
        return this.personajeRepository.save(personaje);
    }

    @Override
    public Page<Personaje> paginado(Pageable paginado) {
        return this.personajeRepository.findAll(paginado);
    }


}
