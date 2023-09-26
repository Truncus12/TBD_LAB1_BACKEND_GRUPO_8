package com.example.TBDBackend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @PostMapping("/usuario")
    Usuario insertarUsuario(@RequestBody Usuario nUsuario){
        return new Usuario(nUsuario.nombre, nUsuario.correo);
    }
}