package cl.tbd.TBD_LAB1_BACKEND.Services;

import java.util.List;

import org.postgis.PGgeometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVistaCercania;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.TareaRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareas;

    @Autowired VoluntarioService voluntarioService;
    
    public List<DTOTareaVista> porUsuario(int id_usuario){
        return tareas.porUsuario(id_usuario);
    }
    
    public List<DTOTareaVistaCercania> porUsuarioCercania(int id_usuario, int limite){
        PGgeometry ubicacion = voluntarioService.obtenerUbicacion(id_usuario);
        return tareas.porUsuarioCercania2(ubicacion, limite);
    }

    public DTOTareaVista terminar(long id, int id_usuario){
        tareas.Actualizar_Tarea_Estado(id);
        return tareas.terminar(id, id_usuario);
    }

    public DTOTareaVista cancelar(long id, int id_usuario){
        return tareas.cancelar(id, id_usuario);
    }
}