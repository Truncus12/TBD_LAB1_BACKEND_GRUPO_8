package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.UsuarioEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @PostMapping("/usuario")
    UsuarioEntity insertarUsuario(@RequestBody UsuarioEntity nUsuario){
        return new UsuarioEntity(nUsuario.getNombre(), nUsuario.getCorreo());
    }
}
