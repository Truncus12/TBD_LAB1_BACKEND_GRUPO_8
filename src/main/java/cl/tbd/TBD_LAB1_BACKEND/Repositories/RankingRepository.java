package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.RankingEntity;

import java.util.List;

public interface RankingRepository {
    int insertarRanking(RankingEntity ranking);

    List<RankingEntity> obtenerRankings();

    List<RankingEntity> obtenerRankingsPorTarea(Long id_tarea);

    List<RankingEntity> obtenerRankingsPorVoluntario(Long id_voluntario);

    RankingEntity obtenerRankingPorId(Long id);

    int actualizarRanking(Long id, RankingEntity ranking);

    int eliminarRanking(Long id);
}