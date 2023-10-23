package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Tarea_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.Tarea_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tarea_HabilidadService {
    @Autowired
    private Tarea_HabilidadRepository tareaHabilidadRepository;

    public int insertarTarea_Habilidad(Tarea_HabilidadEntity tareaHabilidad) {
        return tareaHabilidadRepository.insertarTarea_Habilidad(tareaHabilidad);
    }

    public List<Tarea_HabilidadEntity> obtenerTodosLosTarea_Habilidad() {
        return tareaHabilidadRepository.obtenerTodosLosTarea_Habilidad();
    }

    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorHabilidad(Long idHabilidad) {
        return tareaHabilidadRepository.obtenerTarea_HabilidadesPorHabilidad(idHabilidad);
    }

    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorTarea(Long idTarea) {
        return tareaHabilidadRepository.obtenerTarea_HabilidadesPorTarea(idTarea);
    }

    public Tarea_HabilidadEntity obtenerTarea_Habilidad(Long id) {
        return tareaHabilidadRepository.obtenerTarea_HabilidadPorId(id);
    }

    public int actualizarTarea_Habilidad(Long id, Tarea_HabilidadEntity tareaHabilidad) {
        return tareaHabilidadRepository.actualizarTarea_Habilidad(id, tareaHabilidad);
    }

    public int eliminarTarea_Habilidad(Long id) {
        return tareaHabilidadRepository.eliminarTarea_Habilidad(id);
    }

    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorEmergencia(Long idEmergencia) {
        return tareaHabilidadRepository.obtenerTarea_HabilidadesPorEmergencia(idEmergencia);
    }
}
