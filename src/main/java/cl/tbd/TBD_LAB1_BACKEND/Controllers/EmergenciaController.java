package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
