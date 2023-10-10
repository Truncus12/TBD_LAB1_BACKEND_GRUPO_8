package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class HabilidadEntity {
    private Long id;
    private String descripcion;

    public HabilidadEntity() {
    }

    public HabilidadEntity(Long id, String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
