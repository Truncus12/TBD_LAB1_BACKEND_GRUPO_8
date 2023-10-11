package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Eme_HabilidadEntity;

import java.util.List;

public interface Eme_HabilidadRepository {

    int insertarEme_Habilidad(Eme_HabilidadEntity eme_habilidad);

    List<Eme_HabilidadEntity> obtenerTodosLosEme_Habilidad();

    List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorEmergencia(Long id_emergencia);

    List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorHabilidad(Long id_habilidad);

    Eme_HabilidadEntity obtenerEme_HabilidadPorId(Long id);

    int actualizarEme_Habilidad(Long id, Eme_HabilidadEntity eme_habilidad);

    int eliminarEme_Habilidad(Long id);
}
