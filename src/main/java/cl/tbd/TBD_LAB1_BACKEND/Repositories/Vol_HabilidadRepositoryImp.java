package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Vol_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Vol_HabilidadRepositoryImp implements Vol_HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarVol_Habilidad(Vol_HabilidadEntity vol_habilidad){
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Vol_Habilidad(id_habilidad,id_voluntario) " +
                    "VALUES(:id_habilidad, :id_voluntario)";
            conn.createQuery(sql)
                    .addParameter("id_habilidad",vol_habilidad.getId_habilidad())
                    .addParameter("id_voluntario",vol_habilidad.getId_voluntario())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Vol_HabilidadEntity> obtenerTodosLosVol_Habilidad(){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                            "FROM Vol_Habilidad";
            return conn.createQuery(sql,true)
                    .executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorHabilidad(Long id_habilidad){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                            "FROM Vol_Habilidad " +
                            "WHERE id_habilidad = :id_habilidad";
            return conn.createQuery(sql,true)
                    .addParameter("id_habilidad",id_habilidad)
                    .executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorVoluntario(Long id_voluntario){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                            "FROM Vol_Habilidad " +
                            "WHERE id_voluntario = :id_voluntario";
            return conn.createQuery(sql,true)
                    .addParameter("id_voluntario",id_voluntario)
                    .executeAndFetch(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Vol_HabilidadEntity obtenerVol_HabilidadPorId(Long id){
        try(Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                            "FROM Vol_Habilidad " +
                            "WHERE id = :id";
            return conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarVol_Habilidad(Long id, Vol_HabilidadEntity vol_habilidad){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "UPDATE Vol_Habilidad " +
                            "SET id_habilidad = :id_habilidad, id_voluntario = :id_voluntario " +
                            "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("id_habilidad",vol_habilidad.getId_habilidad())
                    .addParameter("id_voluntario",vol_habilidad.getId_voluntario())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarVol_Habilidad(Long id){
        try (Connection conn = sql2o.open()) {
            String sql =
                    "DELETE FROM Vol_Habilidad " +
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
