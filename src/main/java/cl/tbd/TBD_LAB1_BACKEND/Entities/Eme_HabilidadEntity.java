package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class Eme_HabilidadEntity {
    private Long id;
    private Long id_emergencia;
    private Long id_habilidad;

    public Eme_HabilidadEntity() {
    }

    public Eme_HabilidadEntity(Long id_emergencia, Long id_habilidad) {
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Long getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
