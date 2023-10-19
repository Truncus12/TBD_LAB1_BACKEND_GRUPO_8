package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;
import cl.tbd.TBD_LAB1_BACKEND.Services.TareaService;

@RestController
@RequestMapping("api/tarea")
public class TareaController {
    @Autowired
    private TareaService servicio_tarea;
    @Autowired
    private AutenticacionService servicio_auth;
    
    @GetMapping("por-usuario")
    public List<DTOTareaVista> porUsuario(@CookieValue("token_sesion") String jwt){
        return servicio_tarea
            .porUsuario(
                servicio_auth.getIdVoluntario(jwt)
            );
    }

    @PostMapping("{id}/completar")
    public DTOTareaVista completar(@CookieValue("token_sesion") String jwt, @PathVariable("id") long id_tarea){
        return servicio_tarea
            .completar(
                id_tarea, 
                servicio_auth.getIdVoluntario(jwt)
            );
    }
}
