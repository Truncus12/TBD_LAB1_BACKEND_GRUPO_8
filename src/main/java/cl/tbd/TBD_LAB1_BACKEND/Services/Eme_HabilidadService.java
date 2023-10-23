package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Eme_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.Eme_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Eme_HabilidadService {
    @Autowired
    private Eme_HabilidadRepository eme_habilidadRepository;


    public int insertarEme_Habilidad(Eme_HabilidadEntity emeHabilidad) {
        return eme_habilidadRepository.insertarEme_Habilidad(emeHabilidad);
    }

    public List<Eme_HabilidadEntity> obtenerTodosLosEme_Habilidad() {
        return eme_habilidadRepository.obtenerTodosLosEme_Habilidad();
    }

    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorHabilidad(Long idHabilidad) {
        return eme_habilidadRepository.obtenerEme_HabilidadesPorHabilidad(idHabilidad);
    }

    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorEmergencia(Long idEmergencia) {
        return eme_habilidadRepository.obtenerEme_HabilidadesPorEmergencia(idEmergencia);
    }

    public Eme_HabilidadEntity obtenerEme_HabilidadPorId(Long id) {
        return eme_habilidadRepository.obtenerEme_HabilidadPorId(id);
    }

    public int actualizarEme_Habilidad(Long id, Eme_HabilidadEntity emeHabilidad) {
        return eme_habilidadRepository.actualizarEme_Habilidad(id, emeHabilidad);
    }

    public int eliminarEme_Habilidad(Long id) {
        return eme_habilidadRepository.eliminarEme_Habilidad(id);
    }
}
