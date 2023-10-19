package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarVoluntario(VoluntarioEntity voluntario) {
        try(Connection conexion = sql2o.open()){
            String sql = """
                INSERT INTO Voluntario (nombre, correo, contrasena)
                VALUES (:nombre, :correo, :contrasena)
                """;
            return conexion.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .executeUpdate()
                    .getKey(Integer.class);
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<VoluntarioEntity> obtenerVoluntarios() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Voluntario")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity obtenerVoluntarioPorId(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Voluntario WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int actualizarVoluntario(Long id, VoluntarioEntity voluntario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Voluntario " +
                            "SET nombre = :nombre, correo = :correo, contrasena = :contrasena " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int eliminarVoluntario(Long id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Voluntario WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int idPorCredenciales(String correo, String contrasena){
        try(Connection conexion = sql2o.open()){
            return conexion.createQuery("""
                    SELECT id
                    FROM Voluntario
                    WHERE
                        correo = :correo
                    AND contrasena = :contra
                    """)
                .addParameter("correo", correo)
                .addParameter("contra", contrasena)
                .executeAndFetchFirst(Integer.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}