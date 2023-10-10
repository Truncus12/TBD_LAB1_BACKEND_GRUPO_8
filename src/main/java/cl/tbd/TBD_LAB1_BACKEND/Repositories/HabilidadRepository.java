package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.HabilidadEntity;

import java.util.List;

public interface HabilidadRepository {
    int insertarHabilidad(HabilidadEntity habilidad);

    List<HabilidadEntity> obtenerHabilidades();

    HabilidadEntity obtenerHabilidadPorId(Long id);

    int actualizarHabilidad(Long id, HabilidadEntity habilidad);

    int eliminarHabilidad(Long id);
}
