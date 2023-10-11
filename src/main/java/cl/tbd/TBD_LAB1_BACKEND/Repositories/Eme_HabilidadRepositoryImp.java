package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Eme_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Eme_HabilidadRepositoryImp implements Eme_HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarEme_Habilidad(Eme_HabilidadEntity eme_habilidad){
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Eme_Habilidad(id_emergencia,id_habilidad) " +
                    "VALUES(:id_emergencia, :id_habilidad)";
            conn.createQuery(sql)
                    .addParameter("id_emergencia",eme_habilidad.getId_emergencia())
                    .addParameter("id_habilidad",eme_habilidad.getId_habilidad())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Eme_HabilidadEntity> obtenerTodosLosEme_Habilidad(){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Eme_habilidad";
            return conn.createQuery(sql,true)
                    .executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorEmergencia(Long id_emergencia){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Eme_Habilidad " +
                    "WHERE id_emergencia = :id_emergencia";
            return conn.createQuery(sql,true)
                    .addParameter("id_emergencia",id_emergencia)
                    .executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorHabilidad(Long id_habilidad){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Eme_Habilidad " +
                    "WHERE id_habilidad = :id_habilidad";
            return conn.createQuery(sql,true)
                    .addParameter("id_habilidad",id_habilidad)
                    .executeAndFetch(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Eme_HabilidadEntity obtenerEme_HabilidadPorId(Long id){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "SELECT * " +
                    "FROM Eme_Habilidad " +
                    "WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarEme_Habilidad(Long id, Eme_HabilidadEntity eme_habilidad){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "UPDATE Eme_Habilidad " +
                    "SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad " +
                    "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("id_emergencia",eme_habilidad.getId_emergencia())
                    .addParameter("id_habilidad",eme_habilidad.getId_habilidad())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarEme_Habilidad(Long id){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "DELETE FROM Eme_Habilidad " +
                    "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
