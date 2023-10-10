package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class InstitucionEntity {
    private Long id;
    private String nombre;

    public InstitucionEntity() {
    }

    public InstitucionEntity(Long id, String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
