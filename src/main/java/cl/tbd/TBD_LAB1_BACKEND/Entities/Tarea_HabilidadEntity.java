package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class Tarea_HabilidadEntity {
    private Long id;
    private Long id_emergencia;
    private Long id_habilidad;
    private Long id_tarea;

    public Tarea_HabilidadEntity() {
    }

    public Tarea_HabilidadEntity(Long id_emergencia, Long id_habilidad, Long id_tarea) {
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
        this.id_tarea = id_tarea;
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

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }
}
