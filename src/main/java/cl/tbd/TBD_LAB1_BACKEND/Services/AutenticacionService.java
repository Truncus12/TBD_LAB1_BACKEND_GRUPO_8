package cl.tbd.TBD_LAB1_BACKEND.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;


@Service
public class AutenticacionService {
    @Autowired
    private JwtDecoder decodificador;

    public int getIdVoluntario(String token){
        return Integer.parseInt(
            decodificador.decode(token).getClaimAsString("id_voluntario")
        );
    }
}
