package cl.tbd.TBD_LAB1_BACKEND.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOIniciarSesion;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.VoluntarioRepository;


@Service
public class AutenticacionService {
    @Autowired
    private VoluntarioRepository voluntarios;

    public String generarToken(DTOIniciarSesion dto){
        int id_voluntario = voluntarios.idPorCredenciales(
            dto.correo, 
            dto.contrasena
        );

        if(id_voluntario == -1)
            throw new RuntimeException("No se encuentra un voluntario con esas credenciales");

        return JWT
            .create()
            .withClaim("rol", "voluntario")
            .withClaim("id_voluntario", id_voluntario)
            .sign(Algorithm.HMAC256("asd123"));
    }


    public int getIdVoluntario(String token){
        return JWT
            .decode(token)
            .getClaim("id_voluntario").asInt();
    }
}
