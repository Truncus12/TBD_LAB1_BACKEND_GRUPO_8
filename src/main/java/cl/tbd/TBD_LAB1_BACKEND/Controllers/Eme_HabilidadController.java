package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Eme_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.Eme_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/eme_habilidad")
public class Eme_HabilidadController {
    @Autowired
    private Eme_HabilidadService eme_habilidadService;

    @PostMapping
    public int insertarEme_Habilidad(Eme_HabilidadEntity eme_habilidad){
        return eme_habilidadService.insertarEme_Habilidad(eme_habilidad);
    }
    @GetMapping
    public List<Eme_HabilidadEntity> obtenerTodosLosEme_Habilidad(){
        return eme_habilidadService.obtenerTodosLosEme_Habilidad();
    }
    @GetMapping("/habilidad/{idHabilidad}")
    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorHabilidad(@PathVariable("idHabilidad") Long idHabilidad){
        return eme_habilidadService.obtenerEme_HabilidadesPorHabilidad(idHabilidad);
    }
    @GetMapping("/emergencia/{id_emergencia}")
    public List<Eme_HabilidadEntity> obtenerEme_HabilidadesPorEmergencia(@PathVariable("id_emergencia") Long id_emergencia){
        return eme_habilidadService.obtenerEme_HabilidadesPorEmergencia(id_emergencia);
    }

    @GetMapping("{id}")
    public Eme_HabilidadEntity obtenerEme_HabilidadPorId(@PathVariable("id") Long id){
        return eme_habilidadService.obtenerEme_HabilidadPorId(id);
    }
    @PutMapping("/{id}")
    public int actualizarEme_Habilidad(@PathVariable("id") Long id, @RequestBody Eme_HabilidadEntity eme_habilidad){
        return eme_habilidadService.actualizarEme_Habilidad(id, eme_habilidad);
    }
    @DeleteMapping("/{id}")
    public int eliminarEme_Habilidad(@PathVariable("id") Long id){
        return eme_habilidadService.eliminarEme_Habilidad(id);
    }
}
