package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOVistaMapa;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;
import cl.tbd.TBD_LAB1_BACKEND.Services.TareaService;
import cl.tbd.TBD_LAB1_BACKEND.Services.VoluntarioService;

@RestController
@RequestMapping("api/tarea")
public class TareaController {
    @Autowired
    private VoluntarioService servicio_voluntario;
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
    public DTOVistaMapa porUsuarioCercania(@CookieValue("token_sesion") String jwt, int limite){
        int id_voluntario = servicio_auth.getIdVoluntario(jwt);

        return new DTOVistaMapa(
            servicio_voluntario.obtenerUbicacionVista(id_voluntario),
            servicio_tarea
                .porUsuarioCercania(
                    id_voluntario,
                    limite
            )
        );
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

    @PostMapping
    public int insertarTarea(@RequestBody DTOTareaVista tarea) {
        return servicio_tarea.insertarTarea(tarea);
    }
}
