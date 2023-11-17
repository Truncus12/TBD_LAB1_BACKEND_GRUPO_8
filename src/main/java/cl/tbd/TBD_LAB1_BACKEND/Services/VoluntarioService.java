package cl.tbd.TBD_LAB1_BACKEND.Services;

import cl.tbd.TBD_LAB1_BACKEND.DTOs.DTORegistrar;
import cl.tbd.TBD_LAB1_BACKEND.Entities.VoluntarioEntity;
import cl.tbd.TBD_LAB1_BACKEND.Repositories.VoluntarioRepository;
import org.postgis.PGgeometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    public int insertarVoluntario(VoluntarioEntity voluntario) {
        return voluntarioRepository.insertarVoluntario(voluntario);
    }

    public List<VoluntarioEntity> obtenerVoluntarios() {
        return voluntarioRepository.obtenerVoluntarios();
    }

    public VoluntarioEntity obtenerVoluntarioPorId(Long id) {
        return voluntarioRepository.obtenerVoluntarioPorId(id);
    }

    public int actualizarVoluntario(Long id, VoluntarioEntity voluntario) {
        return voluntarioRepository.actualizarVoluntario(id, voluntario);
    }

    public int eliminarVoluntario(Long id) {
        return voluntarioRepository.eliminarVoluntario(id);
    }

    public int registrar(DTORegistrar dto){
        return voluntarioRepository.insertarVoluntario(
            new VoluntarioEntity(dto.nombre, dto.correo, dto.contrasena)
        );
    }

    public PGgeometry obtenerUbicacion(int idUsuario) {
        return voluntarioRepository.obtenerUbicacion(idUsuario);
    }
}
