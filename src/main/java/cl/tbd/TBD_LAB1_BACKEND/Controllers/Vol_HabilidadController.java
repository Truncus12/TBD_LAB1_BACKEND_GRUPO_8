package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Vol_HabilidadEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.Vol_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vol_habilidad")
public class Vol_HabilidadController {
    @Autowired
    private Vol_HabilidadService vol_habilidadService;

    @PostMapping
    public int insertarVol_Habilidad(Vol_HabilidadEntity vol_habilidad) {
        return vol_habilidadService.insertarVol_Habilidad(vol_habilidad);
    }

    @GetMapping
    public List<Vol_HabilidadEntity> obtenerTodosLosVol_Habilidad() {
        return vol_habilidadService.obtenerTodosLosVol_Habilidad();
    }

    @GetMapping("/habilidad/{id_habilidad}")
    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorHabilidad(Long id_habilidad) {
        return vol_habilidadService.obtenerVol_HabilidadesPorHabilidad(id_habilidad);
    }

    @GetMapping("/voluntario/{id_voluntario}")
    public List<Vol_HabilidadEntity> obtenerVol_HabilidadesPorVoluntario(Long id_voluntario) {
        return vol_habilidadService.obtenerVol_HabilidadesPorVoluntario(id_voluntario);
    }

    @GetMapping("/{id}")
    public Vol_HabilidadEntity obtenerVol_HabilidadPorId(Long id) {
        return vol_habilidadService.obtenerVol_HabilidadPorId(id);
    }

    @PutMapping("/{id}")
    public int actualizarVol_Habilidad(@PathVariable("id") Long id, @RequestBody Vol_HabilidadEntity vol_habilidad) {
        return vol_habilidadService.actualizarVol_Habilidad(id, vol_habilidad);
    }

    @DeleteMapping("/{id}")
    public int eliminarVol_Habilidad(@PathVariable("id") Long id) {
        return vol_habilidadService.eliminarVol_Habilidad(id);
    }
}
