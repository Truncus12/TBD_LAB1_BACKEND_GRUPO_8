package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.RankingEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @PostMapping
    public int insertarRanking(@RequestBody RankingEntity ranking) {
        return rankingService.insertarRanking(ranking);
    }

    @GetMapping
    public List<RankingEntity> obtenerRankings() {
        return rankingService.obtenerRankings();
    }

    @GetMapping
    public RankingEntity obtenerRankingPorId(@PathVariable Long id) {
        return rankingService.obtenerRankingPorId(id);
    }

    @GetMapping
    public List<RankingEntity> obtenerRankingsPorTarea(Long id_tarea) {
        return rankingService.obtenerRankingsPorTarea(id_tarea);
    }

    @GetMapping
    public List<RankingEntity> obtenerRankingsPorVoluntario(Long id_voluntario) {
        return rankingService.obtenerRankingsPorVoluntario(id_voluntario);
    }

    @PutMapping
    public int actualizarRanking(@PathVariable Long id, @RequestBody RankingEntity ranking) {
        return rankingService.actualizarRanking(id, ranking);
    }

    @DeleteMapping
    public int eliminarRanking(@PathVariable Long id) {
        return rankingService.eliminarRanking(id);
    }
}
