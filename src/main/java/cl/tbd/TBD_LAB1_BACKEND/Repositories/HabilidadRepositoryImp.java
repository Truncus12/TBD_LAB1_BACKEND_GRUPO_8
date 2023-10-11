package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarHabilidad(HabilidadEntity habilidad){
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Habilidad (descripcion)" +
                    "VALUES(:descripcion)";
            conn.createQuery(sql,true)
                    .addParameter("descripcion",habilidad.getDescripcion())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<HabilidadEntity> obtenerHabilidades(){
        try (Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Habilidad";
            return conn.createQuery(sql,true)
                    .executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public HabilidadEntity obtenerHabilidadPorId(Long id){
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Habilidad WHERE id = :id";
            return conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(HabilidadEntity.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarHabilidad(Long id, HabilidadEntity habilidad){
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE Habilidad SET descripcion WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .addParameter("descripcion",habilidad.getDescripcion())
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarHabilidad(Long id){
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE INTO Habilidad WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
