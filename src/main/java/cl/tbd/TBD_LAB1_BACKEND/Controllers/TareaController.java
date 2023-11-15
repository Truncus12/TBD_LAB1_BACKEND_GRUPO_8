package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVistaCercania;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;
import cl.tbd.TBD_LAB1_BACKEND.Services.TareaService;

@RestController
@RequestMapping("api/tarea")
public class TareaController {
    @Autowired
    private TareaService servicio_tarea;
    @Autowired
    private AutenticacionService servicio_auth;
    
    @GetMapping
    public List<DTOTareaVista> porUsuario(@CookieValue("token_sesion") String jwt){
        return servicio_tarea
            .porUsuario(
                servicio_auth.getIdVoluntario(jwt)
            );
    }

    @GetMapping("por-cercania")
    public List<DTOTareaVistaCercania> porUsuarioCercania(@CookieValue("token_sesion") String jwt, int limite){
        ArrayList<DTOTareaVistaCercania> tareas = new ArrayList<>();
        
        Random generador = new Random(1000);

        for(int i=1; i<=limite; i++){
            DTOTareaVistaCercania tarea = new DTOTareaVistaCercania();

            tarea.id = i;
            tarea.nombre = "Tarea " + i;
            tarea.descripcion = "Tarea de ejemplo " + i;
            tarea.latitud = -generador.nextDouble() * 0.1 - 33.5;
            tarea.longitud = -generador.nextDouble() * 0.1 - 70.5;
            tarea.distancia = Math.sqrt(
                (tarea.latitud + 70.5) * (tarea.latitud + 70.5) + 
                (tarea.longitud + 33.5) * (tarea.longitud + 33.5)
            );

            tareas.add(tarea);
        }

        return tareas;
        
        /*
        return servicio_tarea
            .porUsuarioCercania(
                servicio_auth.getIdVoluntario(jwt),
                limite
            );
        */
    }

    @PostMapping("{id}/terminar")
    public DTOTareaVista terminar(@CookieValue("token_sesion") String jwt, @PathVariable("id") long id_tarea){
        return servicio_tarea
            .terminar(
                id_tarea, 
                servicio_auth.getIdVoluntario(jwt)
            );
    }
    
    @PostMapping("{id}/cancelar")
    public DTOTareaVista cancelar(@CookieValue("token_sesion") String jwt, @PathVariable("id") long id_tarea){
        return servicio_tarea
            .cancelar(
                id_tarea, 
                servicio_auth.getIdVoluntario(jwt)
            );
    }
}
