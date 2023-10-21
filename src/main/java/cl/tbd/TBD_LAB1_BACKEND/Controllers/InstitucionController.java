package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.InstitucionEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/institucion")
public class InstitucionController {
    @Autowired
    InstitucionService institucionService;

    @PostMapping
    public int insertarInstitucion(@RequestBody InstitucionEntity institucion) {
        return institucionService.insertarInstitucion(institucion);
    }

    @GetMapping
    public List<InstitucionEntity> obtenerInstituciones() {
        return institucionService.obtenerInstituciones();
    }

    @GetMapping("/{id}")
    public InstitucionEntity obtenerInstitucionPorId(@PathVariable Long id) {
        return institucionService.obtenerInstitucionPorId(id);
    }

    @PutMapping("/{id}")
    public int actualizarInstitucion(@PathVariable Long id, @RequestBody InstitucionEntity institucion) {
        return institucionService.actualizarInstitucion(id, institucion);
    }

    @DeleteMapping("/{id}")
    public int eliminarInstitucion(@PathVariable Long id) {
        return institucionService.eliminarInstitucion(id);
    }
}
