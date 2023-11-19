package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOEmergenciaVista;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;
import cl.tbd.TBD_LAB1_BACKEND.Services.EmergenciaService;

@RestController
@RequestMapping("api/emergencia")
public class EmergenciaController {
    @Autowired
    private EmergenciaService servicio_emergencia;
    @Autowired
    private AutenticacionService servicio_auth;

    @GetMapping
    public List<DTOEmergenciaVista> porUsuario(@CookieValue("token_sesion") String jwt){
        return servicio_emergencia.porUsuario(
            servicio_auth.getIdCoordinador(jwt)
        );
    }

    @PostMapping
    public int insertarEmergencia(@RequestBody DTOEmergenciaVista emergencia){
        return servicio_emergencia.insertarEmergencia(emergencia);
    }
}
