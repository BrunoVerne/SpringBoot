package servicios;

import dominio.Socio;

import java.util.List;
import java.util.Optional;


public interface SocioService {

    List<Socio> findAll();
    Socio getById(Long id);
    Socio createSocio(Socio socio);

}
