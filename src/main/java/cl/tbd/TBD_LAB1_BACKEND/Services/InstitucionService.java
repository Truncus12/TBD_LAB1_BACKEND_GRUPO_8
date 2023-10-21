package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.Entities.InstitucionEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    @Autowired
    InstitucionRepository institucionRepository;
    public int insertarInstitucion(InstitucionEntity institucion) {
        return institucionRepository.insertarInstitucion(institucion);
    }

    public List<InstitucionEntity> obtenerInstituciones() {
        return institucionRepository.obtenerInstituciones();
    }

    public InstitucionEntity obtenerInstitucionPorId(Long id) {
        return institucionRepository.obtenerInstitucionPorId(id);
    }

    public int actualizarInstitucion(Long id, InstitucionEntity institucion) {
        return institucionRepository.actualizarInstitucion(id, institucion);
    }

    public int eliminarInstitucion(Long id) {
        return institucionRepository.eliminarInstitucion(id);
    }
}
