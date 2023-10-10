package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioService {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    public int insertarVoluntario(VoluntarioEntity voluntario){
        return voluntarioRepository.insertarVoluntario(voluntario);
    }
}
