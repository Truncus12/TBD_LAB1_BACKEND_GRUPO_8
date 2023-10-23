package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.RankingEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;
    public int insertarRanking(RankingEntity ranking) {
        return rankingRepository.insertarRanking(ranking);
    }

    public List<RankingEntity> obtenerRankings() {
        return rankingRepository.obtenerRankings();
    }

    public RankingEntity obtenerRankingPorId(Long id) {
        return rankingRepository.obtenerRankingPorId(id);
    }

    public List<RankingEntity> obtenerRankingsPorTarea(Long idTarea) {
        return rankingRepository.obtenerRankingsPorTarea(idTarea);
    }

    public List<RankingEntity> obtenerRankingsPorVoluntario(Long idVoluntario) {
        return rankingRepository.obtenerRankingsPorVoluntario(idVoluntario);
    }

    public int actualizarRanking(Long id, RankingEntity ranking) {
        return rankingRepository.actualizarRanking(id, ranking);
    }

    public int eliminarRanking(Long id) {
        return rankingRepository.eliminarRanking(id);
    }
}
