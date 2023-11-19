package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVistaCercania;
import cl.tbd.TBD_LAB1_BACKEND.Entities.EstadoTareaEnum;
import cl.tbd.TBD_LAB1_BACKEND.Entities.TareaEntity;
import org.postgis.PGgeometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    private Sql2o sql2o;

    final String infoTarea = "Tarea.*, st_x(st_astext(geom)) AS longitud, st_y(st_astext(geom)) AS latitud";

    @Override
    public int insertarTarea(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            String point = "POINT("+tarea.getLongitud()+" "+tarea.getLatitud()+")";

            String sql = "INSERT INTO Tarea (nombre, descripcion, cant_vol_requeridos, cant_vol_inscritos, fecha_inicio, fecha_fin, estado_actual, id_emergencia, geom)" +
                    "VALUES (:nombre, :descripcion, :cant_vol_requeridos, :cant_vol_inscritos, :fecha_inicio, :fecha_fin, :estado_actual, :id_emergencia, ST_GeomFromText(:point, 4326))";
            conn.createQuery(sql, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("fecha_inicio", tarea.getFecha_inicio())
                    .addParameter("fecha_fin", tarea.getFecha_fin())
                    .addParameter("estado_actual", tarea.getEstado_actual())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("point", point)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<TareaEntity> obtenerTareas() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT " + infoTarea + " FROM Tarea";
            return conn.createQuery(sql, true)
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaEntity> obtenerTareasPorEmergencia(Long id_emergencia) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT " + infoTarea + " FROM Tarea WHERE id_emergencia = :id_emergencia";
            return conn.createQuery(sql, true)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TareaEntity obtenerTareaPorId(Long id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT " + infoTarea + " FROM Tarea WHERE id = :id";
            return conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarTarea(Long id, TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            String point = "POINT("+tarea.getLongitud()+" "+tarea.getLatitud()+")";
            conn.createQuery("UPDATE Tarea " +
                            "SET nombre = :nombre, descripcion = :descripcion, cant_vol_requeridos = :cant_vol_requeridos, cant_vol_inscritos = :cant_vol_inscritos, fecha_inicio = :fecha_inicio, fecha_fin = :fecha_fin, estado_actual = :estado_actual, id_emergencia = :id_emergencia, geom = ST_GeomFromText(:point, 4326) " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("fecha_inicio", tarea.getFecha_inicio())
                    .addParameter("fecha_fin", tarea.getFecha_fin())
                    .addParameter("estado_actual", tarea.getEstado_actual())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("point", point)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarTarea(Long id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Tarea WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<DTOTareaVista> porUsuario(int id_voluntario){
        try(Connection conexion = sql2o.open()){
            return conexion.createQuery(
                    "SELECT * FROM VistaTareaVoluntario WHERE id_voluntario = :id"
                )
                .addParameter("id", id_voluntario)
                .throwOnMappingFailure(false)
                .executeAndFetch(DTOTareaVista.class);           
        }
        catch(Exception error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public List<DTOTareaVistaCercania> porUsuarioCercania(int id_voluntario, int limite){
        try(Connection conexion = sql2o.open()){
            return conexion.createQuery(
                    "SELECT * FROM VistaTareaVoluntarioCercania WHERE id_voluntario = :id LIMIT :limite"
                )
                .addParameter("id", id_voluntario)
                .addParameter("limite", limite)
                .executeAndFetch(DTOTareaVistaCercania.class);
        }
        catch(Exception error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public List<DTOTareaVistaCercania> porUsuarioCercania2(PGgeometry ubicacion, int limite) {
        try (Connection conexion = sql2o.open()) {
            return conexion.createQuery(
                            "SELECT * FROM obtener_tareas_cercanas(ST_GeomFromText(:ubicacion), :limite)")
                    .addParameter("ubicacion", ubicacion.toString())
                    .addParameter("limite", limite)
                    .executeAndFetch(DTOTareaVistaCercania.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    @Override
    public DTOTareaVista terminar(long id, int id_voluntario){
        try(Connection conexion = sql2o.open()){
            conexion.createQuery("""
                UPDATE Tarea_X_Voluntario
                SET 
                    estado = :id_estado
                WHERE 
                    id_tarea = :id 
                AND id_voluntario = :id_voluntario
                    """
                )
                .addParameter("id", id)
                .addParameter("id_voluntario", id_voluntario)
                .addParameter("id_estado", EstadoTareaEnum.TERMINADA.id)
                .executeUpdate();
        }
        catch(Exception error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public DTOTareaVista cancelar(long id, int id_voluntario){
        try(Connection conexion = sql2o.open()){
            conexion.createQuery("""
                UPDATE Tarea_X_Voluntario
                SET 
                    estado = :id_estado
                WHERE 
                    id_tarea = :id 
                AND id_voluntario = :id_voluntario
                    """
                )
                .addParameter("id", id)
                .addParameter("id_voluntario", id_voluntario)
                .addParameter("id_estado", EstadoTareaEnum.CANCELADA.id)
                .executeUpdate();
        }
        catch(Exception error){
            error.printStackTrace();
        }

        return null;
    }
    @Override
    public void Actualizar_Tarea_Estado(long id) {
        try (Connection conexion = sql2o.open()) {
            conexion.createQuery("SELECT actualizar_estado_tarea(:idTarea)")
                    .addParameter("idTarea", id)
                    .executeAndFetchFirst(Void.class);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}