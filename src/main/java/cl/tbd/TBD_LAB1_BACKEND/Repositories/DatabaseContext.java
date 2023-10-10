package cl.tbd.TBD_LAB1_BACKEND.Repositories;

import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public abstract class DatabaseContext
{
    protected Sql2o sql2o;

    public DatabaseContext(){
        // Cambiar por sus credenciales
        sql2o = new Sql2o("jdbc:postgresql://localhost:5432/tbd_lab1", "postgres", "adm123");
    }
}