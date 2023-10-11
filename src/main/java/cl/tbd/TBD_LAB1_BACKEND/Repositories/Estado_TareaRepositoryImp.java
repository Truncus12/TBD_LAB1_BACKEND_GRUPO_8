package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Estado_TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Estado_TareaRepositoryImp implements Estado_TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarEstado_Tarea(Estado_TareaEntity estado_tarea){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Estado_Tarea(descripcion,id_tarea)" +
                    "VALUES (:descripcion, :id_tarea";
            conn.createQuery(sql,true)
                    .addParameter("descripcion",estado_tarea.getDescripcion())
                    .addParameter("id_tarea",estado_tarea.getId_tarea())
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Estado_TareaEntity> obtenerTodosLosEstado_Tarea(){
        try (Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Estado_Tarea";
            return conn.createQuery(sql,true)
                    .executeAndFetch(Estado_TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Estado_TareaEntity> obtenerEstado_TareasPorTarea(Long id_tarea){
        try (Connection conn = sql2o.open()) {
            String sql ="SELECT * FROM Estado_Tarea WHERE id_tarea = :id_tarea";
            return conn.createQuery(sql,true)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Estado_TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_TareaEntity obtenerEstado_TareaPorId(Long id){
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM Estado_Tarea WHERE id = :id";
            return conn.createQuery(sql,true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Estado_TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarEstado_Tarea(Long id, Estado_TareaEntity estado_tarea){
        try(Connection conn = sql2o.open()){
            String sql = "UPDATE Estaod_Tarea SET descripcion = :descripcion, id_tarea = :id_tarea WHERE id = :id";
            conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .addParameter("descripcion",estado_tarea.getDescripcion())
                    .addParameter("id_tarea",estado_tarea.getId_tarea())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarEstado_Tarea(Long id){
        try (Connection conn = sql2o.open()){
            String sql = "DELETE INTO Estado_tarea WHERE id = :id";
            conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
