package servicios;

import dominio.Socio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.ISocioRepository;
import repositorios.SocioRepositoryMemory;

import java.util.List;
import java.util.Optional;

@Service
public class SocioServiceImpl implements  SocioService{

    private ISocioRepository socioRepository;

    public SocioServiceImpl() {
        this.socioRepository = new SocioRepositoryMemory();
    }

    @Override
    public List<Socio> findAll() {
        return this.socioRepository.findAll();
    }

    @Override
    public Socio getById(Long id) {
        Optional<Socio> oSocio = this.socioRepository.getById(id);
        if(oSocio.isPresent()){
            return oSocio.get();
        }
        return null;
    }

    @Override
    public Socio createSocio(Socio socio) {
        if(!this.socioRepository.EsSocioExistente(socio.getEmail())){
            return  this.socioRepository.createSocio(socio);

        }
        return null;
    }
}
