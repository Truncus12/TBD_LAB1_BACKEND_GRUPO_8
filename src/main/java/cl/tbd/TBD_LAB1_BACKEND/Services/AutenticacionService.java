package cl.tbd.TBD_LAB1_BACKEND.Services;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;


@Service
public class AutenticacionService {
    public int getIdVoluntario(String token){
        return JWT
            .decode(token)
            .getClaim("id_voluntario").asInt();
    }
}
