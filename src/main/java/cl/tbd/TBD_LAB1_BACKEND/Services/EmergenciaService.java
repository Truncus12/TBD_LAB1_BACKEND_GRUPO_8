package cl.tbd.TBD_LAB1_BACKEND.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTOEmergenciaVista;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.EmergenciaRepository;

@Service
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository emergencias;
    
    public List<DTOEmergenciaVista> porUsuario(int id_coordinador){
        return emergencias.porUsuario(id_coordinador);
    }
}
