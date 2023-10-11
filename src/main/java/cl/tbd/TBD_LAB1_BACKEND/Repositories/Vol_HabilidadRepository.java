package cl.tbd.TBD_LAB1_BACKEND.Repositories;



import cl.tbd.TBD_LAB1_BACKEND.Entities.Vol_HabilidadEntity;

import java.util.List;

public interface Vol_HabilidadRepository {

    int insertarVol_Habilidad(Vol_HabilidadEntity vol_habilidad);

    List<Vol_HabilidadEntity> obtenerTodosLosVol_Habilidad();

    List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorHabilidad(Long id_habilidad);

    List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorVoluntario(Long id_voluntario);

    Vol_HabilidadEntity obtenerVol_HabilidadPorId(Long id);

    int actualizarVol_Habilidad(Long id, Vol_HabilidadEntity vol_habilidad);

    int eliminarVol_Habilidad(Long id);
}
