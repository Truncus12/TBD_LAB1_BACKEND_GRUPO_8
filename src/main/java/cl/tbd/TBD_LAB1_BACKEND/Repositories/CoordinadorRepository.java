package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class CoordinadorRepository {
    @Autowired
    private Sql2o sql2o;

    public int idPorCredenciales(String correo, String contrasena){
        try(Connection conexion = sql2o.open()){
            return conexion
                .createQuery("""
                    SELECT id
                    FROM Coordinador
                    WHERE
                        correo = :correo
                    AND contrasena = :contrasena
                """)
                .addParameter("correo", correo)
                .addParameter("contrasena", contrasena)
                .executeAndFetchFirst(Integer.class);
        }
        catch(Exception err){
            err.printStackTrace();
        }

        return -1;
    }
}
