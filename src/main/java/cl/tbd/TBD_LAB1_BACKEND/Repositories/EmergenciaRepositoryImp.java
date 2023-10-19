package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOEmergenciaVista;
import cl.tbd.TBD_LAB1_BACKEND.Entities.EmergenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarEmergencia(EmergenciaEntity emergencia){
        try (Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO Emergencia(nombre,despcripcion,fecha_inicio,fecha_fin,id_institucion)"+
                    "VALUES(:nombre, :descripcion, :fecha_inicio, :fecha_fin, :id_institucion)";
            conn.createQuery(sql)
                    .addParameter("nombre",emergencia.getNombre())
                    .addParameter("descripcion",emergencia.getDescripcion())
                    .addParameter("fecha_inicio",emergencia.getFecha_inicio())
                    .addParameter("fecha_fin",emergencia.getFecha_fin())
                    .addParameter("id_institucion",emergencia.getId_institucion())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<EmergenciaEntity> obtenerEmergencias(){
        try (Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Emergencia";
            return conn.createQuery(sql,true)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergenciaEntity> obtenerEmergenciasPorInstitucion(Long id_institucion){
        try (Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Emergencia " +
                    "WHERE id_institution = : id_institucion";
            return conn.createQuery(sql,true)
                    .addParameter("id_institucion",id_institucion)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmergenciaEntity obtenerEmergenciaPorId(Long id){
        try (Connection conn = sql2o.open()){
            String sql =
                    "SELECT * " +
                    "FROM Emergencia " +
                    "WHERE id = :id";
            return conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarEmergencia(Long id, EmergenciaEntity emergencia){
        try (Connection conn = sql2o.open()){
            String sql =
                    "UPDATE Emergencia " +
                    "SET nombre = :nombre, " +
                    "descripcion = :despcrion, fecha_inicio = :fecha_inicio, " +
                    "fecha_fin = :fecha_fin, id_institucion = :id_institucion " +
                    "WHERE id  = :id";
            conn.createQuery(sql)
                    .addParameter("nombre",emergencia.getNombre())
                    .addParameter("descripcion",emergencia.getDescripcion())
                    .addParameter("fecha_inicio",emergencia.getFecha_inicio())
                    .addParameter("fecha_fin",emergencia.getFecha_fin())
                    .addParameter("id_institucion",emergencia.getId_institucion())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarEmergencia(Long id){
        try (Connection conn = sql2o.open()){
            String sql =
                    "DELETE FROM Emergencia " +
                    "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<DTOEmergenciaVista> porUsuario(int id_coordinador) {
        try(Connection conexion = sql2o.open()){
            return conexion.createQuery("""
                        SELECT 
                    """)
                    .addParameter("id_coordinador",id_coordinador)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DTOEmergenciaVista.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
