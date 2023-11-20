package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTORegistrar;
import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOVoluntarioUbicacion;
import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.AutenticacionService;
import cl.tbd.TBD_LAB1_BACKEND.Services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioService voluntarioService;
    @Autowired
    AutenticacionService servicio_auth;

    @PostMapping("registrar")
    public int registrar(@RequestBody DTORegistrar dto){
        return voluntarioService.registrar(dto);
    }

    @PostMapping
    public int insertarVoluntario(@RequestBody VoluntarioEntity voluntario) {
        return voluntarioService.insertarVoluntario(voluntario);
    }

    @GetMapping
    public List<VoluntarioEntity> obtenerVoluntarios() {
        return voluntarioService.obtenerVoluntarios();
    }

    @GetMapping("/{id}")
    public VoluntarioEntity obtenerVoluntarioPorId(@PathVariable Long id) {
        return voluntarioService.obtenerVoluntarioPorId(id);
    }

    @PutMapping("/{id}")
    public int actualizarVoluntario(@PathVariable Long id, @RequestBody VoluntarioEntity voluntario) {
        return voluntarioService.actualizarVoluntario(id, voluntario);
    }

    @PutMapping("/{id}/ubicacion")
    public void actualizarUbicacion(@CookieValue("token_sesion") String jwt, @RequestBody DTOVoluntarioUbicacion ubicacion){
        voluntarioService.actualizarUbicacion(
            (long) servicio_auth.getIdVoluntario(jwt),
            ubicacion
        );
    }

    @DeleteMapping("/{id}")
    public int eliminarVoluntario(@PathVariable Long id) {
        return voluntarioService.eliminarVoluntario(id);
    }
}