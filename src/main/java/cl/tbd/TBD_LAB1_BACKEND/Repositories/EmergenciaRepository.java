package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOEmergenciaVista;
import cl.tbd.TBD_LAB1_BACKEND.Entities.EmergenciaEntity;

import java.util.List;

public interface EmergenciaRepository {
    int insertarEmergencia(EmergenciaEntity emergencia);

    List<EmergenciaEntity> obtenerEmergencias();

    List<EmergenciaEntity> obtenerEmergenciasPorInstitucion(Long id_institucion);

    EmergenciaEntity obtenerEmergenciaPorId(Long id);

    int actualizarEmergencia(Long id, EmergenciaEntity emergencia);

    int eliminarEmergencia(Long id);

    List<DTOEmergenciaVista> porUsuario(int id_coordinador);
}
