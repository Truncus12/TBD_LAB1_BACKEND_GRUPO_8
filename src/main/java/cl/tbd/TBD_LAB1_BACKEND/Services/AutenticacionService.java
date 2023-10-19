package cl.tbd.TBD_LAB1_BACKEND.Services;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


@Service
public class AutenticacionService {
    public String generarToken(){
        return JWT
            .create()
            .withClaim("rol", "voluntario")
            .withClaim("id_voluntario", 1)
            .sign(Algorithm.HMAC256("asd123"));
    }


    public int getIdVoluntario(String token){
        return JWT
            .decode(token)
            .getClaim("id_voluntario").asInt();
    }
}
