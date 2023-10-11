package cl.tbd.TBD_LAB1_BACKEND.Repositories;


import cl.tbd.TBD_LAB1_BACKEND.Entities.Tarea_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Tarea_HabilidadRepositoryImp implements Tarea_HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarTarea_Habilidad(Tarea_HabilidadEntity tarea_habilidad){
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea_Habilidad(id_emergencia,id_habilidad,id_tarea)"+
                    "VALUES (:id_emergencia, :id_habilidad, :id_tarea)";
            conn.createQuery(sql)
                    .addParameter("id_emergencia",tarea_habilidad.getId_emergencia())
                    .addParameter("id_habilidad",tarea_habilidad.getId_habilidad())
                    .addParameter("id_tarea",tarea_habilidad.getId_tarea())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Tarea_HabilidadEntity> obtenerTodosLosTarea_Habilidad(){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "SELECT * " +
                    "FROM Tarea_Habilidad";
            return conn.createQuery(sql,true)
                    .executeAndFetch(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorEmergencia(Long id_emergencia){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Tarea_Habilidad " +
                    "WHERE id_emergencia = :id_emergencia";
            return conn.createQuery(sql,true)
                    .addParameter("id_emergencia",id_emergencia)
                    .executeAndFetch(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorHabilidad(Long id_habilidad){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Tarea_Habilidad " +
                    "WHERE id_habilidad = :id_habilidad";
            return conn.createQuery(sql,true)
                    .addParameter("id_habilidad",id_habilidad)
                    .executeAndFetch(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorTarea(Long id_tarea){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                            "FROM Tarea_Habilidad " +
                            "WHERE id_tarea = :id_tarea";
            return conn.createQuery(sql,true)
                    .addParameter("id_tarea",id_tarea)
                    .executeAndFetch(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_HabilidadEntity obtenerTarea_HabilidadPorId(Long id){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "SELECT * " +
                            "FROM Tarea_Habilidad " +
                            "WHERE id = :id";
            return conn.createQuery(sql,true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarTarea_Habilidad(Long id, Tarea_HabilidadEntity tarea_habilidad){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "UPDATE Tarea_Habilidad " +
                            "SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad, id_tarea = :id_tarea " +
                            "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("id_emergencia",tarea_habilidad.getId_emergencia())
                    .addParameter("id_habilidad",tarea_habilidad.getId_habilidad())
                    .addParameter("id_tarea",tarea_habilidad.getId_tarea())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarTarea_Habilidad(Long id){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "DELETE FROM Tarea_Habilidad " +
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
