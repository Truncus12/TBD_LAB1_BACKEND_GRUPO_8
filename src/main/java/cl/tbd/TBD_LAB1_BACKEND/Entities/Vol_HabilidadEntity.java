package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class Vol_HabilidadEntity {
    private Long id;
    private Long id_habilidad;
    private Long id_voluntario;

    public Vol_HabilidadEntity() {
    }

    public Vol_HabilidadEntity(Long id_habilidad, Long id_voluntario) {
        this.id_habilidad = id_habilidad;
        this.id_voluntario = id_voluntario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
}
