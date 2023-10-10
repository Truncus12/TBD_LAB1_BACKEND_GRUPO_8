package cl.tbd.TBD_LAB1_BACKEND.Entities;

public class UsuarioEntity {

    private Long id;
    String nombre;
    String correo;

    public UsuarioEntity(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
