package Spring.Proyecto.services;

import Spring.Proyecto.Repositories.IPersonajeRepository;
import Spring.Proyecto.domain.Personaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private final IPersonajeRepository personajeRepository; //Este Repo usa el Repository personalizado mio
                                                                     //(IPersonajeRepository)

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return personajeRepository.getAllPersonajes() ;
    }

    @Override
    public Personaje getById(long id) {
        Optional<Personaje> optionalPersonaje = this.personajeRepository.getById(id);
        if(optionalPersonaje.isPresent()){
            return  optionalPersonaje.get();
        }
        return null;
    }

    @Override
    public Personaje createPersonaje(Personaje personaje) {
        if(!this.personajeRepository.existePersonaje(personaje)){
            return this.personajeRepository.createPersonaje(personaje);

        }
        return null;
    }

    @Override
    public Page<Personaje> paginado(Pageable paginado) {
        return null ;
    }


}
