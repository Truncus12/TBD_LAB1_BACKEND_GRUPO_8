package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.Services.TareaService;

@RestController
@RequestMapping("api/tarea")
public class TareaController {
    @Autowired
    private TareaService servicio_tarea;
    
    @GetMapping("por-usuario")
    public List<DTOTareaVista> porUsuario(@RequestParam("id") int id){
        return servicio_tarea.porUsuario(id);
    }
}
