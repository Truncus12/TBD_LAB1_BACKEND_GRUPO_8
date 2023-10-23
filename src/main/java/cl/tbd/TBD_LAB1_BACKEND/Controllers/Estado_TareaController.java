package cl.tbd.TBD_LAB1_BACKEND.Controllers;

import cl.tbd.TBD_LAB1_BACKEND.Entities.Estado_TareaEntity;
import cl.tbd.TBD_LAB1_BACKEND.Services.Estado_TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estado_tarea")
public class Estado_TareaController {
    @Autowired
    private Estado_TareaService estado_tareaService;

    @PostMapping
    public int insertarEstado_Tarea(Estado_TareaEntity estado_tarea){
        return estado_tareaService.insertarEstado_Tarea(estado_tarea);
    }

    @GetMapping
    public List<Estado_TareaEntity> obtenerTodosLosEstado_Tarea(){
        return estado_tareaService.obtenerTodosLosEstado_Tarea();
    }

    @GetMapping("/{id}")
    public Estado_TareaEntity obtenerEstado_TareaPorId(@PathVariable("id") Long id){
        return estado_tareaService.obtenerEstado_TareaPorId(id);
    }

    @GetMapping("/tarea/{id_tarea}")
    public List<Estado_TareaEntity> obtenerEstado_TareasPorTarea(@PathVariable("id_tarea") Long id_tarea){
        return estado_tareaService.obtenerEstado_TareasPorTarea(id_tarea);
    }

    @PutMapping("/{id}")
    public int actualizarEstado_Tarea(@PathVariable("id") Long id, @RequestBody Estado_TareaEntity estado_tarea){
        return estado_tareaService.actualizarEstado_Tarea(id, estado_tarea);
    }

    @DeleteMapping("/{id}")
    public int eliminarEstado_Tarea(@PathVariable("id") Long id){
        return estado_tareaService.eliminarEstado_Tarea(id);
    }
}
