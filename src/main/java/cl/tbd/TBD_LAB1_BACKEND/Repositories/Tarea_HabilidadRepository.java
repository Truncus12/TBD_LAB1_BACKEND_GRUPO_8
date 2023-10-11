package cl.tbd.TBD_LAB1_BACKEND.Repositories;



import cl.tbd.TBD_LAB1_BACKEND.Entities.Tarea_HabilidadEntity;

import java.util.List;

public interface Tarea_HabilidadRepository {

    int insertarTarea_Habilidad(Tarea_HabilidadEntity tarea_habilidad);

    List<Tarea_HabilidadEntity> obtenerTodosLosTarea_Habilidad();

    List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorEmergencia(Long id_emergencia);

    List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorHabilidad(Long id_habilidad);

    List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorTarea(Long id_tarea);

    Tarea_HabilidadEntity obtenerTarea_HabilidadPorId(Long id);

    int actualizarTarea_Habilidad(Long id, Tarea_HabilidadEntity tarea_habilidad);

    int eliminarTarea_Habilidad(Long id);
}
