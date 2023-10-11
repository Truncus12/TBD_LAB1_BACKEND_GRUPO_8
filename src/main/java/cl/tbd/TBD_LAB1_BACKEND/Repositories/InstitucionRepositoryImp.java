package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import cl.tbd.TBD_LAB1_BACKEND.Entities.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertarInstitucion(InstitucionEntity institucion){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Institucion (nombre)" +
                    "VALUES (:nombre)";
            conn.createQuery(sql,true)
                    .addParameter("nombre",institucion.getNombre())
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }

    }

    @Override
    public List<InstitucionEntity> obtenerInstituciones(){
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Institucion";
            return conn.createQuery(sql,true)
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public InstitucionEntity obtenerInstitucionPorId(Long id){
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM Institucion WHERE id=:id";
            return conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(InstitucionEntity.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public int actualizarInstitucion(Long id, InstitucionEntity institucion){
        try(Connection conn = sql2o.open()){
            String sql = "UPDATE Institucion SET nombre = :nombre WHERE id = :id";
            conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .addParameter("nombre",institucion.getNombre())
                    .executeUpdate();
            return 1;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    @Override
    public int eliminarInstitucion(Long id){
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM Institucion WHERE id = :id";
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
