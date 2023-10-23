package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    public int insertarHabilidad(HabilidadEntity habilidad) {
        return habilidadRepository.insertarHabilidad(habilidad);
    }

    public List<HabilidadEntity> obtenerHabilidades() {
        return habilidadRepository.obtenerHabilidades();
    }

    public HabilidadEntity obtenerHabilidadPorId(Long id) {
        return habilidadRepository.obtenerHabilidadPorId(id);
    }

    public int actualizarHabilidad(Long id, HabilidadEntity habilidad) {
        return habilidadRepository.actualizarHabilidad(id, habilidad);
    }

    public int eliminarHabilidad(Long id) {
        return habilidadRepository.eliminarHabilidad(id);
    }
}
