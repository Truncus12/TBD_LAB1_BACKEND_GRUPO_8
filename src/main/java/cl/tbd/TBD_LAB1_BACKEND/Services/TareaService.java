package cl.tbd.TBD_LAB1_BACKEND.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOTareaVista;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.TareaRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareas;
    
    public List<DTOTareaVista> porUsuario(int id_usuario){
        return tareas.porUsuario(id_usuario);
    }

    public DTOTareaVista completar(long id, int id_usuario){
        return tareas.completar(id, id_usuario);
    }
}
