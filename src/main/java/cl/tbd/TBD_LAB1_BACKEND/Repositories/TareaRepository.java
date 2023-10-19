package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.Entities.TareaEntity;

import java.util.List;

public interface TareaRepository {
    int insertarTarea(TareaEntity tarea);

    List<TareaEntity> obtenerTareas();

    List<DTOTareaVista> porUsuario(int id_usuario);

    List<TareaEntity> obtenerTareasPorEmergencia(Long id_emergencia);

    TareaEntity obtenerTareaPorId(Long id);

    int actualizarTarea(Long id, TareaEntity tarea);

    int eliminarTarea(Long id);

    DTOTareaVista completar(long id, int id_voluntario);
}
