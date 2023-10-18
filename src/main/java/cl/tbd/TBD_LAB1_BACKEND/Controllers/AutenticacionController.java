package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Controller
@RequestMapping("api/auth")
public class AutenticacionController {
    @GetMapping
    public ResponseEntity<String> iniciarSesion(){
        String jwt = JWT
            .create()
            .withClaim("rol", "voluntario")
            .withClaim("id_voluntario", 1)
            .sign(Algorithm.HMAC256("asd123"));
        
        ResponseCookie cookie_sesion = ResponseCookie
            .from("token_sesion", jwt)
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
