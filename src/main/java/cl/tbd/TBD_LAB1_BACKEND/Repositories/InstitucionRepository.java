package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {
    int insertarInstitucion(InstitucionEntity institucion);

    List<InstitucionEntity> obtenerInstituciones();

    InstitucionEntity obtenerInstitucionPorId(Long id);

    int actualizarInstitucion(Long id, InstitucionEntity institucion);

    int eliminarInstitucion(Long id);
}