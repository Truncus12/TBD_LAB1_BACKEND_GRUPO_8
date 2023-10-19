package cl.tbd.TBD_LAB1_BACKEND.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOIniciarSesion;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.CoordinadorRepository;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.VoluntarioRepository;


@Service
public class AutenticacionService {
    @Autowired
    private VoluntarioRepository voluntarios;
    @Autowired
    private CoordinadorRepository coordinadores;

    public String generarToken(DTOIniciarSesion dto){
        // Busca en voluntarios
        int id_usuario = voluntarios.idPorCredenciales(
            dto.correo, 
            dto.contrasena
        );

        if(id_usuario != -1){
            return JWT
                .create()
                .withClaim("rol", "voluntario")
                .withClaim("id_voluntario", id_usuario)
                .sign(Algorithm.HMAC256("asd123"));
        }

        // Busca en coordinadores
        id_usuario = coordinadores.idPorCredenciales(
            dto.correo, 
            dto.contrasena
        );

        if(id_usuario != -1){
            return JWT
                .create()
                .withClaim("rol", "coordinador")
                .withClaim("id_coordinador", id_usuario)
                .sign(Algorithm.HMAC256("asd123"));
        }

        throw new RuntimeException("No se encuentra el usuario en el sistema");
    }


    public int getIdVoluntario(String token){
        return JWT
            .decode(token)
            .getClaim("id_voluntario").asInt();
    }

    public int getIdCoordinador(String token){
        return JWT
            .decode(token)
            .getClaim("id_coordinador").asInt();
    }
}
