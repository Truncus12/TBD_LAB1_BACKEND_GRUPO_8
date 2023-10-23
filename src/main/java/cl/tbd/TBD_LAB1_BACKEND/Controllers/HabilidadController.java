package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/habilidad")
public class HabilidadController {
    @Autowired
    HabilidadService habilidadService;

    @PostMapping
    public int insertarHabilidad(@RequestBody HabilidadEntity habilidad) {
        return habilidadService.insertarHabilidad(habilidad);
    }

    @GetMapping
    public List<HabilidadEntity> obtenerHabilidades() {
        return habilidadService.obtenerHabilidades();
    }

    @GetMapping
    public HabilidadEntity obtenerHabilidadPorId(@PathVariable Long id) {
        return habilidadService.obtenerHabilidadPorId(id);
    }

    @PutMapping
    public int actualizarHabilidad(@PathVariable Long id, @RequestBody HabilidadEntity habilidad) {
        return habilidadService.actualizarHabilidad(id, habilidad);
    }

    @DeleteMapping
    public int eliminarHabilidad(@PathVariable Long id) {
        return habilidadService.eliminarHabilidad(id);
    }
}
