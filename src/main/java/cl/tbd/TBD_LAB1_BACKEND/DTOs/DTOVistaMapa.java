package cl.tbd.TBD_LAB1_BACKEND.DTOs;

import java.util.List;

public class DTOVistaMapa {
    public DTOVoluntarioUbicacion ubicacion;
    public List<DTOTareaVistaCercania> tareas;

    public DTOVistaMapa(DTOVoluntarioUbicacion ubicacion, List<DTOTareaVistaCercania> tareas){
        this.ubicacion = ubicacion;
        this.tareas = tareas;
    }
}
