package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Estado_TareaEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.Estado_TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Estado_TareaService {
    @Autowired
    private Estado_TareaRepository estado_tareaRepository;

    public int insertarEstado_Tarea(Estado_TareaEntity estadoTarea) {
        return estado_tareaRepository.insertarEstado_Tarea(estadoTarea);
    }

    public List<Estado_TareaEntity> obtenerTodosLosEstado_Tarea() {
        return estado_tareaRepository.obtenerTodosLosEstado_Tarea();
    }

    public Estado_TareaEntity obtenerEstado_TareaPorId(Long id) {
        return estado_tareaRepository.obtenerEstado_TareaPorId(id);
    }

    public List<Estado_TareaEntity> obtenerEstado_TareasPorTarea(Long idTarea) {
        return estado_tareaRepository.obtenerEstado_TareasPorTarea(idTarea);
    }

    public int actualizarEstado_Tarea(Long id, Estado_TareaEntity estadoTarea) {
        return estado_tareaRepository.actualizarEstado_Tarea(id, estadoTarea);
    }

    public int eliminarEstado_Tarea(Long id) {
        return estado_tareaRepository.eliminarEstado_Tarea(id);
    }
}
