package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOIniciarSesion;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;

@Controller
@RequestMapping("api/auth")
public class AutenticacionController {
    @Autowired
    private AutenticacionService servicio_auth;

    @PostMapping
    public ResponseEntity<String> iniciarSesion(@RequestBody DTOIniciarSesion dto){
        ResponseCookie cookie_sesion = ResponseCookie
            .from("token_sesion", servicio_auth.generarToken(dto))
            .httpOnly(true)
            .secure(true)
            .path("/")
            .build();

        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, cookie_sesion.toString())
            .body("OK");
    }
}
