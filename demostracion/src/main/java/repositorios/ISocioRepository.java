package repositorios;

import dominio.Socio;

import java.util.List;
import java.util.Optional;

public interface ISocioRepository {

    List<Socio> findAll();
    Optional<Socio> getById(Long id);
    Socio createSocio(Socio socio);
    boolean EsSocioExistente(String email);

}

