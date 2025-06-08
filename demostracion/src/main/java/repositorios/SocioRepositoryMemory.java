package repositorios;

import com.google.common.collect.Lists;
import dominio.Socio;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SocioRepositoryMemory implements  ISocioRepository{
    private List<Socio> socios;

    public SocioRepositoryMemory() {
        this.socios = Lists.newArrayList(
                new Socio(1L,"pedro", "ramirez", "pedroramirez@gmail.com"),
                new Socio(2L,"juan", "verne", "juanverne@gmail.com"),
                new Socio(3L,"Maria", "Del valle", "meryDelValle@gmail.com")
        );
    }

    @Override
    public List<Socio> findAll() {
        return this.socios;
    }

    @Override
    public Optional<Socio> getById(Long id) {
        return this.socios
                .stream()
                .filter(soc -> soc.getCodigo().equals(id))
                .findFirst();
    }

    @Override
    public Socio createSocio(Socio socio) {
        socio.setCodigo((long) this.socios.size() + 1);
        this.socios.add(socio);
        return socio;

    }

    @Override
    public boolean EsSocioExistente(String email) {
        return this.socios
                .stream()
                .anyMatch(socio -> socio.getEmail().equals(email));
    }
}
