package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Vol_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.Vol_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vol_HabilidadService {
    @Autowired
    private Vol_HabilidadRepository volHabilidadRepository;
    public int insertarVol_Habilidad(Vol_HabilidadEntity volHabilidad) {
        return volHabilidadRepository.insertarVol_Habilidad(volHabilidad);
    }

    public List<Vol_HabilidadEntity> obtenerTodosLosVol_Habilidad() {
        return volHabilidadRepository.obtenerTodosLosVol_Habilidad();
    }

    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorHabilidad(Long idHabilidad) {
        return volHabilidadRepository.obtenerVol_HabilidadesPorHabilidad(idHabilidad);
    }

    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorVoluntario(Long idVoluntario) {
        return volHabilidadRepository.obtenerVol_HabilidadesPorVoluntario(idVoluntario);
    }

    public Vol_HabilidadEntity obtenerVol_HabilidadPorId(Long id) {
        return volHabilidadRepository.obtenerVol_HabilidadPorId(id);
    }

    public int actualizarVol_Habilidad(Long id, Vol_HabilidadEntity volHabilidad) {
        return volHabilidadRepository.actualizarVol_Habilidad(id, volHabilidad);
    }

    public int eliminarVol_Habilidad(Long id) {
        return volHabilidadRepository.eliminarVol_Habilidad(id);
    }
}
