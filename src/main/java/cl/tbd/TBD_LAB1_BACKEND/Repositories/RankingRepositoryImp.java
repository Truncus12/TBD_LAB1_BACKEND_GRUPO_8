package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarRanking(RankingEntity ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Ranking (puntaje, flag_invitado, flag_participa, id_tarea, id_voluntario)" +
                    "VALUES (:puntaje, :flag_invitado, :flag_participa, :id_tarea, :id_voluntario)";
            conn.createQuery(sql, true)
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flag_invitado", ranking.isFlag_invitado())
                    .addParameter("flag_participa", ranking.isFlag_participa())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<RankingEntity> obtenerRankings() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking")
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> obtenerRankingsPorTarea(Long id_tarea) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking WHERE id_tarea = :id_tarea")
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> obtenerRankingsPorVoluntario(Long id_voluntario) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking WHERE id_voluntario = :id_voluntario")
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RankingEntity obtenerRankingPorId(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarRanking(Long id, RankingEntity ranking) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Ranking " +
                            "SET SET puntaje = :puntaje, flag_invitado = :flag_invitado, flag_participa = :flag_participa " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flag_invitado", ranking.isFlag_invitado())
                    .addParameter("flag_participa", ranking.isFlag_participa())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarRanking(Long id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Ranking WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
