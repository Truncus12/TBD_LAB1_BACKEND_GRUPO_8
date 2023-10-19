package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;

@Controller
@RequestMapping("api/auth")
public class AutenticacionController {
    @Autowired
    private AutenticacionService servicio_auth;

    @GetMapping
    public ResponseEntity<String> iniciarSesion(){
        ResponseCookie cookie_sesion = ResponseCookie
            .from("token_sesion", servicio_auth.generarToken())
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
