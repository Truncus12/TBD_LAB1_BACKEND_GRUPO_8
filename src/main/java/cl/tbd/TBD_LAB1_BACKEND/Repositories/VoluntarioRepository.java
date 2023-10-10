package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;

import java.util.List;

public interface VoluntarioRepository {
    int insertarVoluntario(VoluntarioEntity voluntario);

    List<VoluntarioEntity> obtenerVoluntarios();

    VoluntarioEntity obtenerVoluntarioPorId(Long id);

    int actualizarVoluntario(Long id, VoluntarioEntity voluntario);

    int eliminarVoluntario(Long id);
}
