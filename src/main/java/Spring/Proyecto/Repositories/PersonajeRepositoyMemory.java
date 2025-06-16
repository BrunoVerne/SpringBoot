package Spring.Proyecto.Repositories;

import Spring.Proyecto.domain.Personaje;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
//"base de datos" en memoria para probar IPersonajeRepository y PersonajeServiceImpl
@Repository
public class PersonajeRepositoyMemory implements  IPersonajeRepository{
    public List<Personaje> personajes;



    public PersonajeRepositoyMemory() {
    }

    public PersonajeRepositoyMemory(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return this.personajes;
    }

    @Override
    /*
    optional de Personaje puede devolver null
     */
    public Optional<Personaje> getById(long id) {
        return this.personajes
                .stream()
                .filter( per -> per.getId().equals(id))
                .findFirst();

    }

    @Override
    public Personaje createPersonaje(Personaje personaje) {
        personaje.setId((long) this.personajes.size() + 1);
        this.personajes.add(personaje);
        return personaje;
    }

    @Override
    public boolean existePersonaje(Personaje personaje) {
        return this.personajes
                .stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(personaje.getNombre())
                        && p.getEdad() == personaje.getEdad()
                        && Objects.equals(p.getAsociada(), personaje.getAsociada()));
    }
}

