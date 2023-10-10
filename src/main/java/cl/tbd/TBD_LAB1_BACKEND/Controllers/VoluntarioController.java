package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioService voluntarioService;
    @PostMapping("registrar")
    public int insertarVoluntario(@RequestBody VoluntarioEntity voluntario){
       return voluntarioService.insertarVoluntario(voluntario);
    }
}
