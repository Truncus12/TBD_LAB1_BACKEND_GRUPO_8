package cl.tbd.TBD_LAB1_BACKEND.DTOs;

import java.util.List;

import org.postgis.Point;

public class DTOVistaMapa {
    double longitud_voluntario;
    double latitud_voluntario;

    List<DTOTareaVistaCercania> tareas;

    public DTOVistaMapa(Point ubicacion, List<DTOTareaVistaCercania> tareas){
        this.longitud_voluntario = ubicacion.getX();
        this.latitud_voluntario = ubicacion.getY();
        
        this.tareas = tareas;
    }
}
