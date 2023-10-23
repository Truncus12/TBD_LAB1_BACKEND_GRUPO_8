package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Tarea_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.Tarea_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarea_habilidad")
public class Tarea_HabilidadController {
    @Autowired
    private Tarea_HabilidadService tareaHabilidadService;

    @PostMapping
    public int insertarTarea_Habilidad(Tarea_HabilidadEntity tareaHabilidad) {
        return tareaHabilidadService.insertarTarea_Habilidad(tareaHabilidad);
    }

    @GetMapping
    public List<Tarea_HabilidadEntity> obtenerTodosLosTarea_Habilidad() {
        return tareaHabilidadService.obtenerTodosLosTarea_Habilidad();
    }

    @GetMapping("/emergencia/{idEmergencia}")
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorEmergencia(Long idEmergencia) {
        return tareaHabilidadService.obtenerTarea_HabilidadesPorEmergencia(idEmergencia);
    }

    @GetMapping("/habilidad/{idHabilidad}")
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorHabilidad(Long idHabilidad) {
        return tareaHabilidadService.obtenerTarea_HabilidadesPorHabilidad(idHabilidad);
    }

    @GetMapping("/tarea/{idTarea}")
    public List<Tarea_HabilidadEntity> obtenerTarea_HabilidadesPorTarea(Long idTarea) {
        return tareaHabilidadService.obtenerTarea_HabilidadesPorTarea(idTarea);
    }

    @GetMapping("/{id}")
    public Tarea_HabilidadEntity obtenerTarea_Habilidad(Long id) {
        return tareaHabilidadService.obtenerTarea_Habilidad(id);
    }

    @PutMapping("/{id}")
    public int actualizarTarea_Habilidad(Long id, Tarea_HabilidadEntity tareaHabilidad) {
        return tareaHabilidadService.actualizarTarea_Habilidad(id, tareaHabilidad);
    }

    @DeleteMapping("/{id}")
    public int eliminarTarea_Habilidad(Long id) {
        return tareaHabilidadService.eliminarTarea_Habilidad(id);
    }
}
