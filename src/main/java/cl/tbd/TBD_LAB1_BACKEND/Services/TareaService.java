package cl.tbd.TBD_LAB1_BACKEND.Services;

import java.util.List;

import cl.tbd.TBD_LAB1_BACKEND.Entities.TareaEntity;
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
        return tareas.porUsuarioCercania(ubicacion, limite);
    }

    public DTOTareaVista terminar(long id, int id_usuario){
        tareas.Actualizar_Tarea_Estado(id);
        return tareas.terminar(id, id_usuario);
    }

    public DTOTareaVista cancelar(long id, int id_usuario){
        return tareas.cancelar(id, id_usuario);
    }

    public int insertarTarea(DTOTareaVista tarea) {
        TareaEntity tareaEntity = new TareaEntity(
            tarea.nombre,
            tarea.descripcion,
            tarea.cant_vol_requeridos,
            tarea.cant_vol_inscritos,
            tarea.fecha_inicio,
            tarea.fecha_fin,
            tarea.estado_actual,
            tarea.id_emergencia,
            tarea.longitud,
            tarea.latitud
        );
        return tareas.insertarTarea(tareaEntity);
    }
}