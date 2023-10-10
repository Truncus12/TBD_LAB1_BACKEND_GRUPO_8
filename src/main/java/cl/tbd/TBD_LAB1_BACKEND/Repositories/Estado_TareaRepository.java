package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Estado_TareaEntity;

import java.util.List;

public interface Estado_TareaRepository {
    int insertarEstado_Tarea(Estado_TareaEntity estado_tarea);

    List<Estado_TareaEntity> obtenerTodosLosEstado_Tarea();

    List<Estado_TareaEntity> obtenerEstado_TareasPorTarea(Long id_tarea);

    Estado_TareaEntity obtenerEstado_TareaPorId(Long id);

    int actualizarEstado_Tarea(Long id, Estado_TareaEntity estado_tarea);

    int eliminarEstado_Tarea(Long id);
}
